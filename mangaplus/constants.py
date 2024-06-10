from enum import Enum


class Language(Enum):
    # @jp.co.shueisha.mangaplus.fragment.v6;
    ENGLISH = 'eng'
    SPANISH = 'esp'
    THAI = 'tha'
    PORTUGUESE_BR = 'ptb'
    INDONESIAN = 'ind'
    RUSSIAN = 'rus'
    FRENCH = 'fra'
    GERMAN = 'deu'
    VIETNAMESE = 'vie'


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
