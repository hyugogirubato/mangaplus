import re

from pathlib import Path

PARENT = Path(__file__).parent.resolve()

# Markers for protobuf definitions
MAGIC_PROTO = ['message ', 'enum ']
PROTO_HEADER = [
    'syntax = "proto3";\n',
    'package mangaplus_api;\n',
    'option java_package = "jp.co.comic.jump.proto";\n'
]

if __name__ == '__main__':
    protos = PARENT / 'protos'

    content = []
    # Collect message/enum definitions from all .proto files
    for path in (PARENT / 'protos').glob('*.proto'):
        lines = path.read_text(encoding='utf-8').splitlines()

        # Skip lines until a message/enum definition is found
        i = 0
        while i < len(lines):
            line = lines[i]
            if any(line.startswith(m) for m in MAGIC_PROTO):
                break
            i += 1

        # Keep only definitions
        content.append('\n'.join(lines[i:]).strip() + '\n')

    # Join header + cleaned content, removing outer prefixes (A.B → B)
    content = '\n'.join([
        *PROTO_HEADER,
        re.sub(r'\b\w+\.(\w+)', r'\1', '\n'.join(content))
    ])

    # Write combined proto file
    file_path = PARENT / 'mangaplus_api.proto'
    file_path.write_text(content)

    # https://github.com/protocolbuffers/protobuf/releases
    # https://pypi.org/project/protoc-wheel-0/3.19.4/
    # Protobuf Python Version: 5.29.5
    # Manga Plus Version: 1.23.1
    # protoc -I. --python_out=. --mypy_out=. mangaplus_api.proto
