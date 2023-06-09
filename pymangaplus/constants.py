from enum import Enum


class Language(Enum):
    ENGLISH = "eng"
    SPANISH = "esp"
    FRENCH = "fra"
    INDONESIAN = "ind"
    PORTUGUESE = "ptb"
    RUSSIAN = "rus"
    THAI = "tha"


class Mode(Enum):
    ADD = "add"
    DELETE = "delete"


class Quality(Enum):
    LOW = "low"
    HIGH = "high",
    SUPER_HIGH = "super_high"
