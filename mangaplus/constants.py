from enum import Enum


class Language(Enum):
    # @package jp.co.shueisha.mangaplus.util.LanguageUtilKt;
    ENGLISH = 'eng'
    SPANISH = 'esp'
    FRENCH = 'fra'
    INDONESIAN = 'ind'
    PORTUGUESE_BR = 'ptb'
    RUSSIAN = 'rus'
    THAI = 'tha'
    VIETNAMESE = 'vie'
    GERMAN = 'deu'


class Viewer(Enum):
    # @package jp.co.shueisha.mangaplus.activity.ViewerActivity;
    HORIZONTAL = 'horizontal'
    VERTICAL = 'vertical'


class Quality(Enum):
    # @jp.co.shueisha.mangaplus.fragment.ContentOptionsActivity;
    LOW = 'low'
    HIGH = 'high'
    SUPER_HIGH = 'super_high'


class Ranking(Enum):
    # @package jp.co.shueisha.mangaplus.fragment.p6;
    HOTTEST = 'hottest'
    TRENDING = 'trending'
    COMPLETED = 'completed'
