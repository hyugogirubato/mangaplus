from google.protobuf.json_format import MessageToDict

from mangaplus.protocol.mangaplus_api_pb2 import Response


def bool2str(value: bool) -> str:
    """Convert a boolean value to a string representation."""
    return 'yes' if value else 'no'


def proto2dict(data: bytes) -> dict:
    """
    Parse a serialized protobuf response into a Python dictionary.

    Args:
        data (bytes): Serialized protobuf message (from the MangaPlus API).

    Returns:
        dict: Dictionary representation of the protobuf message.
    """
    response = Response()
    response.ParseFromString(data)
    return MessageToDict(response)
