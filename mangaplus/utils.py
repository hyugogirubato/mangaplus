import re
from typing import Union

from google.protobuf.json_format import MessageToDict
from pathlib import Path

from mangaplus.mangaplus_api_protocol_pb2 import Response


def bool2str(value: bool) -> str:
    return 'yes' if value else 'no'


def proto2dict(data: bytes) -> dict:
    response = Response()
    response.ParseFromString(data)
    return MessageToDict(response)


def sanitize_path(path: Union[Path, str]) -> Path:
    invalid_chars = r'[<>:"/|?*\x00-\x1F]'

    # Replace invalid characters with an underscore
    sanitized_path_str = re.sub(invalid_chars, '_', str(path))

    # Convert the sanitized string to a Path object
    sanitized_path = Path(sanitized_path_str)

    return Path(sanitized_path)
