import re

from itertools import takewhile
from pathlib import Path
from typing import List

# Regex patterns for extracting Java -> Proto elements
MAGIC_PACKAGE = re.compile(r'package\s+([\w.]+)\s*;')
MAGIC_CLASS = re.compile(r'public\s+final\s+class\s+(\w+)\s*\{')
MAGIC_MESSAGE = re.compile(r'public\s+static\s+final\s+class\s+(\w+)\s+extends\s+GeneratedMessageLite')
MAGIC_MESSAGE_FIELD = re.compile('public static final int (\w+)_FIELD_NUMBER\s*=\s*(\d+);')
MAGIC_ENUM = re.compile('public\s+enum\s+(\w+)')
MAGIC_ENUM_FIELD = re.compile('(\w+)\s*\(\s*(-?\d+)\s*\)')

# Patterns for handling internal list + type mapping
INTERNAL_PROTO_LIST = re.compile(r'Internal\.ProtobufList<([\w.]+)>')
INTERNAL_PROTO_TYPE = {
    'int': 'int32',
    'String': 'string',
    'boolean': 'bool'
}


class Parser(object):
    """Parses Java-generated protobuf classes into .proto definitions."""

    def __init__(self, path: Path):
        self.lines = path.read_text(encoding='utf-8').splitlines()
        self.proto_package = None
        self.proto_imports = []
        self.proto_class = None
        self.proto_messages = {}
        self.proto_enums = {}

        # Run parsing immediately
        self.proto_parsed = self.__parse()

    def __parse(self) -> List[str]:
        """Extract package, imports, classes, messages, and enums from Java source."""
        content = []

        i = 0
        while i < len(self.lines):
            line = self.lines[i].strip()

            # Capture package line
            if not self.proto_package:
                m = re.search(MAGIC_PACKAGE, line)
                if m:
                    self.proto_package = m.group(1)
                    content += [line, '']

            # Capture imports from same package
            elif self.proto_package and line.startswith(f'import {self.proto_package}.'):
                self.proto_imports.append(line.split(f'{self.proto_package}.')[1].split(';')[0])
                content.append(line)

            # Capture main class
            elif not self.proto_class:
                m = re.search(MAGIC_CLASS, line)
                if m:
                    self.proto_class = m.group(1)
                    content += ['', line]

            # Capture message definitions
            elif re.match(MAGIC_MESSAGE, line):
                m = re.search(MAGIC_MESSAGE, line)
                if m.group(1) != 'Builder':
                    fields = sum(1 for _ in takewhile(str.strip, self.lines[i + 1:]))

                    key = m.group(1)
                    self.proto_messages[key] = self.lines[i: i + fields + 1]
                    content += ['', *self.proto_messages[key]]

            # Capture enum definitions
            elif re.match(MAGIC_ENUM, line):
                m = re.search(MAGIC_ENUM, line)
                fields = sum(1 for _ in takewhile(str.strip, self.lines[i + 1:]))

                key = m.group(1)
                self.proto_enums[key] = self.lines[i: i + fields + 1]
                content += ['', *self.proto_enums[key]]

            i += 1

        return content

    def headers(self) -> str:
        """Build proto file header: syntax, package, java_package, imports."""
        content = [
            'syntax = "proto3";\n',
            'package mangaplus_api_protocol;\n',
            f'option java_package = "{self.proto_package}";\n'
        ]

        if self.proto_imports:
            content += [
                f'import "{name}.proto";'
                for name in sorted(self.proto_imports)
            ]
            content.append('')

        return '\n'.join(content).strip()

    def enums(self) -> str:
        """Convert captured enums into .proto format."""
        content = []
        for name, lines in self.proto_enums.items():
            content.append('enum %s {' % name)

            # Build dict: int value -> enum name
            fields = {}
            for line in lines[1:]:
                m = re.search(MAGIC_ENUM_FIELD, line)
                fields[int(m.group(2))] = m.group(1)

            # Append sorted fields
            content += [
                f'  {fields[value]} = {value};'
                for value in sorted(fields.keys())
                if value >= 0  # protobuf 3
            ]

            content.append('}\n')

        return '\n'.join(content).strip()

    def messages(self) -> str:
        """Convert captured messages into .proto format."""
        content = []

        # Iterate over each protobuf message
        for name, lines in parser.proto_messages.items():
            content.append('message %s {' % name)

            fields = {}
            # Extract field names and values using regex
            for line in lines:
                m = re.search(MAGIC_MESSAGE_FIELD, line)
                if m:
                    # Convert snake_case to camelCase (first word lower, rest capitalized)
                    fields[int(m.group(2))] = ''.join([
                        v.capitalize() if i > 0 else v
                        for i, v in enumerate(m.group(1).lower().split('_'))
                    ])

            # Process fields sorted by their numeric value
            for value in sorted(fields.keys()):
                key = fields[value]
                field_key = f'{key}_'

                # Find the actual line defining this field
                field = next((line for line in lines if field_key in line), None)

                # Fallback: case-insensitive search for malformed lines
                if not field:
                    field = next(
                        (line for line in lines
                         if field_key.lower() in line.lower() and '_FIELD_NUMBER' not in line),
                        None
                    )
                    if field:
                        # Extract key from the line
                        key = field.split('_', maxsplit=1)[0].split(' ')[-1]
                        field_key = f'{key}_'

                # Determine the field type
                if field:
                    field_type = field.split(field_key)[0].split(' ')[-2].strip()

                    # Convert repeated ProtobufList types
                    m = re.match(INTERNAL_PROTO_LIST, field_type)
                    if m:
                        field_type = 'repeated ' + INTERNAL_PROTO_TYPE.get(m.group(1), m.group(1))

                    # Convert timestamp int fields to int64
                    if field_type in 'int' and 'timestamp' in field_key.lower():
                        field_type = 'int64'

                    # Map Java types to Protobuf types
                    field_type = INTERNAL_PROTO_TYPE.get(field_type, field_type)
                else:
                    field_key = key.capitalize()
                    internal_fields = [*self.proto_messages.keys(), *self.proto_enums.keys()]
                    if field_key in internal_fields:
                        field_type = field_key
                    else:
                        # Fallback: case-insensitive match against known messages/enums
                        field_type = next((f for f in internal_fields if key.lower() == f.lower()), None)
                        if field_type:
                            key = field_type.replace(field_type[0], field_type[0].lower(), 1)
                        else:
                            field_type = 'unknown'

                # Append the field to the message
                content.append(f'  {field_type} {key} = {value};')

            content.append('}\n')

        return '\n'.join(content).strip()


if __name__ == '__main__':
    path = Path('compiled.java')
    parser = Parser(path)

    print('--- Protobufs ---')
    print('\n'.join(parser.proto_parsed).replace('    ', '|---'))

    # Combine proto output: header, messages, enums
    content = '\n\n'.join([
        parser.headers(),
        parser.messages(),
        parser.enums()
    ]).strip()

    # Save to .proto file
    file_path = Path('protos') / f'{parser.proto_class}.proto'
    file_path.parent.mkdir(parents=True, exist_ok=True)
    file_path.write_text(content)

    print('Parsed:', file_path)
