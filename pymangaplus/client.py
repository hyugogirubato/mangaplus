import hashlib
import requests

from pymangaplus.constants import Language, Mode, Quality
from pymangaplus.utils import proto2dict


class Client:

    def __init__(self, language: Language = Language.ENGLISH):
        self.language = language.value
        self.secret = None
        self.api = "https://jumpg-api.tokyo-cdn.com/api"

    def _request(self, **kwargs) -> dict:
        headers = {
            "accept": "*/*",
            "user-agent": "okhttp/4.9.0"
        }
        headers.update(kwargs.get("headers") or {})

        params = kwargs.get("params") or {}
        params["os"] = "android"
        params["os_ver"] = 29
        params["app_ver"] = 47
        if self._secret:
            params["secret"] = self._secret

        r = requests.request(
            method=kwargs.get("method", "GET"),
            url=kwargs.get("url"),
            params=params,
            data=kwargs.get("data"),
            headers=headers
        )
        r.raise_for_status()
        return proto2dict(r.content)

    # @package jp.co.shueisha.mangaplus.g;
    def settings(self) -> dict:
        return self._request(
            method="GET",
            url=f"{self.api}/settings_v2"
        )["settingsView"]

    def init(self) -> dict:
        return self._request(
            method="GET",
            url=f"{self.api}/init_v2"
        )["initView"]

    def bookmark(self, title_id: int = None, mode: Mode = Mode.ADD) -> dict:
        if title_id:
            params = {"title_id": title_id}
            method = "PUT" if mode == Mode.ADD else "DELETE"
        else:
            params = None
            method = "GET"
        content = self._request(
            method=method,
            url=f"{self.api}/title_list/bookmark",
            params=params
        )
        return content.get("subscribedTitlesView", None) or content

    def publisher_news(self, publisher_id: int) -> dict:
        return self._request(
            method="GET",
            url=f"{self.api}/publisher_news_list",
            params={"publisher_id": publisher_id, "lang": self.language}
        )

    def manga_viewer(
            self,
            chapter_id: int,
            split: bool = True,
            quality: Quality = Quality.HIGH,
            ticket: str = None,
            free: str = None
    ) -> dict:
        return self._request(
            method="GET",
            url=f"{self.api}/manga_viewer",
            params={
                "chapter_id": chapter_id,
                "split": "yes" if split else "false",
                "img_quality": quality.value,
                "ticket_reading": ticket or "",
                "free_reading": free or ""
            }
        )["mangaViewer"]

    def comment(self, chapter_id: int = None, comment_id: int = None, body: str = None) -> dict:
        if chapter_id and body:
            method = "POST"
            params = {"chapter_id": chapter_id, "body": body}
        elif chapter_id:
            method = "GET"
            params = {"chapter_id": chapter_id}
        elif comment_id:
            method = "DELETE"
            params = {"comment_id": comment_id}
        else:
            raise NotImplemented("Error: Method not supported")

        content = self._request(
            method=method,
            url=f"{self.api}/comment",
            params=params
        )
        return content.get("commentView", None) or content

    def featured(self) -> dict:
        return self._request(
            method="GET",
            url=f"{self.api}/featured",
            params={"lang": self.language}
        )["featuredView"]

    def register(self, android_id: str) -> dict:
        # @package jp.co.shueisha.mangaplus.util;
        device_token = hashlib.md5(android_id.encode("utf-8")).hexdigest()
        security_key = hashlib.md5(str(device_token + "4Kin9vGg").encode("utf-8")).hexdigest()

        content = self._request(
            method="PUT",
            url=f"{self.api}/register",
            params={"device_token": device_token, "security_key": security_key}
        )["registerView"]
        self._secret = content["secret"]
        return content

    def ticket_titles(self) -> dict:
        return self._request(
            method="GET",
            url=f"{self.api}/title_list/ticket_titles",
        )

    def home(self) -> dict:
        return self._request(
            method="GET",
            url=f"{self.api}/home_v3",
            params={"lang": self.language}
        )["homeView"]

    def profile(self, icon_id: int = None, username: str = None) -> dict:
        params = {"icon_id": icon_id, "name": username} if icon_id and username else None
        content = self._request(
            method="POST" if params else "GET",
            url=f"{self.api}/profile",
            params=params
        )
        return content["updateProfileView"] if params else content["profileView"]

    def all(self) -> dict:
        return self._request(
            method="GET",
            url=f"{self.api}/title_list/all_v2",
        )["allView"]

    def title_detail(self, title_id: int) -> dict:
        return self._request(
            method="GET",
            url=f"{self.api}/title_detailV2",
            params={"title_id": title_id, "lang": self.language}
        )["titleDetailView"]

    def push_token(self, firebase_token: str = None) -> dict:
        return self._request(
            method="POST" if firebase_token else "DELETE",
            url=f"{self.api}/push_token",
            params={"push_token": firebase_token} if firebase_token else None
        )

    def free_titles(self) -> dict:
        return self._request(
            method="GET",
            url=f"{self.api}/title_list/free_titles",
        )["freeTitlesView"]

    def ranking(self) -> dict:
        return self._request(
            method="GET",
            url=f"{self.api}/title_list/ranking",
        )["rankingView"]

    def comment_like(self, comment_id: int, mode: Mode = Mode.ADD) -> dict:
        return self._request(
            method="POST" if mode == Mode.ADD else "DELETE",
            url=f"{self.api}/push_token",
            params={"comment_id": comment_id}
        )
