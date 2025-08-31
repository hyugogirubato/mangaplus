import hashlib

import requests

from mangaplus.constants import Language, Viewer, Quality, Ranking
from mangaplus.utils import bool2str, proto2dict


class MangaPlus:
    # @package jp.co.shueisha.mangaplus.api.ApiFactory;
    APP_VERSION = 222

    def __init__(
            self,
            lang: Language = Language.ENGLISH,
            clang: [Language] = None,
            viewer: Viewer = Viewer.HORIZONTAL
    ):
        # @package jp.co.shueisha.mangaplus.d;
        self.lang = lang
        self.clang = clang or [Language.ENGLISH]
        self.viewer = viewer

        self.api = 'https://jumpg-api.tokyo-cdn.com/api'
        self.secret = None

    def __request(self, **kwargs) -> dict:
        headers = kwargs.get('headers') or {
            'Accept-Encoding': 'gzip',
            'Connection': 'Keep-Alive',
            'Host': 'jumpg-api.tokyo-cdn.com',
            'User-Agent': 'okhttp/4.12.0'
        }

        params = {
            **kwargs.get('params', {}),
            'os': 'android',
            'os_ver': 29,
            'app_ver': self.APP_VERSION
        }

        if self.secret:
            params['secret'] = self.secret

        r = requests.request(
            method=kwargs['method'],
            url=kwargs['url'],
            params=params,
            headers=headers
        )
        r.raise_for_status()

        # @package jp.co.comic.jump.proto
        data = proto2dict(r.content)
        error = data.get('error')
        if error:
            code = error['englishPopup']['subject'].replace(' ', '')
            message = error['englishPopup']['body']
            raise type(code, (Exception,), {})(message)
        else:
            return data['success']

    @property
    def __clang(self) -> str:
        return ','.join([l.value for l in self.clang])

    @property
    def __viewer(self) -> str:
        return self.viewer.value

    @property
    def __lang(self) -> str:
        return self.lang.value

    # @package jp.co.shueisha.mangaplus.g.b;
    def title_detail(self, title_id: int) -> dict:
        return self.__request(
            method='GET',
            url=f'{self.api}/title_detailV3',
            params={
                'title_id': title_id,
                'lang': self.__lang,
                'clang': self.__clang
            }
        )

    def popup_tap_log(self, popup_id: str) -> dict:
        return self.__request(
            method='GET',
            url=f'{self.api}/popup_tap_log',
            params={'popup_id': popup_id}
        )

    def bookmark_dislike(self, title_id: int) -> dict:
        return self.__request(
            method='DELETE',
            url=f'{self.api}/title_list/bookmark',
            params={'title_id': title_id}
        )

    def banner_tap_log(self, banner_id: str) -> dict:
        return self.__request(
            method='GET',
            url=f'{self.api}/banner_tap_log',
            params={'banner_id': banner_id}
        )

    def history(self) -> dict:
        return self.__request(
            method='GET',
            url=f'{self.api}/title_list/history',
            params={
                'lang': self.__lang,
                'clang': self.__clang
            }
        )

    def comment_dislike(self, comment_id: int) -> dict:
        return self.__request(
            method='DELETE',
            url=f'{self.api}/comment_like',
            params={'comment_id': comment_id}
        )

    def home(self):
        return self.__request(
            method='GET',
            url=f'{self.api}/home_v4',
            params={
                'lang': self.__lang,
                'viewer_mode': self.__viewer,
                'clang': self.__clang
            }
        )

    def ranking(self, ranking: Ranking = Ranking.HOTTEST) -> dict:
        return self.__request(
            method='GET',
            url=f'{self.api}/title_list/rankingV2',
            params={
                'lang': self.__lang,
                'type': ranking.value,
                'clang': self.__clang
            }
        )

    def manga_viewer(
            self,
            chapter_id: int,
            split: bool = True,
            quality: Quality = Quality.SUPER_HIGH,
            ticket: bool = False,
            free: bool = False,
            subscription: bool = False
    ) -> dict:
        return self.__request(
            method='GET',
            url=f'{self.api}/manga_viewer',
            params={
                'chapter_id': chapter_id,
                'split': bool2str(split),
                'img_quality': quality.value,
                'ticket_reading': bool2str(ticket),
                'free_reading': bool2str(free),
                'subscription_reading': bool2str(subscription),
                'viewer_mode': self.__viewer,
                'clang': self.__clang
            }
        )

    def subscription(self) -> dict:
        return self.__request(
            method='GET',
            url=f'{self.api}/subscription'
        )

    def publisher_news_list(self, publisher_id: int) -> dict:
        return self.__request(
            method='GET',
            url=f'{self.api}/publisher_news_list',
            params={
                'publisher_id': publisher_id,
                'lang': self.__lang
            }
        )

    def comments(self, chapter_id: int) -> dict:
        return self.__request(
            method='GET',
            url=f'{self.api}/comment',
            params={'chapter_id': chapter_id}
        )

    def subscription_restore(self, purchase_data: str, signature: str) -> dict:
        return self.__request(
            method='PUT',
            url=f'{self.api}/subscription_restore',
            params={
                'purchase_data': purchase_data,
                'signature': signature
            }
        )

    def comment_delete(self, comment_id: int) -> dict:
        return self.__request(
            method='DELETE',
            url=f'{self.api}/comment',
            params={'comment_id': comment_id}
        )

    def comment_add(self, chapter_id: int, body: str) -> dict:
        return self.__request(
            method='POST',
            url=f'{self.api}/comment',
            params={
                'chapter_id': chapter_id,
                'body': body
            }
        )

    def profile(self) -> dict:
        return self.__request(
            method='GET',
            url=f'{self.api}/profile'
        )

    def token_delete(self) -> dict:
        return self.__request(
            method='DELETE',
            url=f'{self.api}/push_token'
        )

    def free_titles(self) -> dict:
        return self.__request(
            method='GET',
            url=f'{self.api}/title_list/free_titles'
        )

    def comment_like(self, comment_id: int) -> dict:
        return self.__request(
            method='PUT',
            url=f'{self.api}/comment_like',
            params={'comment_id': comment_id}
        )

    def subscription_add(self, purchase_data: str, signature: str) -> dict:
        return self.__request(
            method='PUT',
            url=f'{self.api}/subscription',
            params={
                'purchase_data': purchase_data,
                'signature': signature
            }
        )

    def token_add(self, token: str) -> dict:
        return self.__request(
            method='POST',
            url=f'{self.api}/push_token',
            params={'push_token': token}
        )

    def init(self) -> dict:
        return self.__request(
            method='GET',
            url=f'{self.api}/init_v2'
        )

    def bookmark_like(self, title_id: int) -> dict:
        return self.__request(
            method='PUT',
            url=f'{self.api}/title_list/bookmark',
            params={'title_id': title_id}
        )

    def settings(self) -> dict:
        return self.__request(
            method='GET',
            url=f'{self.api}/settings_v2',
            params={
                'lang': self.__lang,
                'viewer_mode': self.__viewer,
                'clang': self.__clang
            }
        )

    def ad_tap_log(self, chapter_id: int, token: str, type: str) -> dict:
        return self.__request(
            method='GET',
            url=f'{self.api}/ad_tap_log',
            params={
                'chapter_id': chapter_id,
                'token': token,
                'type': type
            }
        )

    def register(self, device_id: str) -> dict:
        # @package jp.co.shueisha.mangaplus.util.j0;
        device_token = hashlib.md5(bytes(device_id, 'utf-8')).hexdigest()
        security_key = hashlib.md5(bytes(device_token + '4Kin9vGg', 'utf-8')).hexdigest()

        content = self.__request(
            method='PUT',
            url=f'{self.api}/register',
            params={
                'device_token': device_token,
                'security_key': security_key
            })
        self.secret = content['registrationData']['deviceSecret']
        return content

    def bookmarks(self) -> dict:
        return self.__request(
            method='GET',
            url=f'{self.api}/title_list/bookmark'
        )

    def search(self) -> dict:
        return self.__request(
            method='GET',
            url=f'{self.api}/title_list/search',
            params={
                'lang': self.__lang,
                'clang': self.__clang
            }
        )

    def ticket_titles(self) -> dict:
        return self.__request(
            method='GET',
            url=f'{self.api}/title_list/ticket_titles'
        )

    def profile_set(self, icon_id: int, name: str) -> dict:
        return self.__request(
            method='POST',
            url=f'{self.api}/profile',
            params={
                'icon_id': icon_id,
                'name': name
            }
        )

    def all(self) -> dict:
        return self.__request(
            method='GET',
            url=f'{self.api}/title_list/all_v2'
        )
