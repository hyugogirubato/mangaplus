import subprocess

from pathlib import Path

PARENT = Path()

if __name__ == '__main__':
    protos = PARENT / 'protos'

    lines = [
        'syntax = "proto3";\n',
        'package mangaplus_api_protocol;\n',
        'option java_package = "jp.co.comic.jump.proto";\n'
    ]
    for proto in protos.glob('*.proto'):
        for line in proto.read_text(encoding='utf-8').strip().splitlines():
            if not any(f for f in ['syntax = ', 'package ', 'option ', 'import "'] if line.startswith(f)):
                lines.append(line)

    file = PARENT / 'mangaplus_api_protocol.proto'
    file.write_text(data='\n'.join(lines).replace('\n\n\n', '\n'), encoding='utf-8')

    # libprotoc 3.12.4
    sp = subprocess.run(['protoc', '--python_out=.', str(file)], capture_output=True)
    if sp.returncode != 0:
        raise EnvironmentError(sp.stderr.decode('utf-8'))
    file.unlink()
