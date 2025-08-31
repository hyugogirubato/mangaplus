from google.protobuf.json_format import MessageToDict

from mangaplus.protocol.mangaplus_api_pb2 import Response


def bool2str(value: bool) -> str:
    return 'yes' if value else 'no'


def proto2dict(data: bytes) -> dict:
    response = Response()
    response.ParseFromString(data)
    return MessageToDict(response)
