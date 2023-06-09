from google.protobuf.json_format import MessageToDict

from pymangaplus import api_protocol_pb2


def proto2dict(proto_data: bytes) -> dict:
    proto = api_protocol_pb2.Response()
    proto.ParseFromString(proto_data)
    dict_data = MessageToDict(proto)
    if "success" in dict_data:
        return dict_data["success"]
    else:
        code = dict_data["error"]["default"]["code"].replace(" ", "")
        message = dict_data["error"]["default"]["message"]
        raise type(code, (Exception,), {})(message)
