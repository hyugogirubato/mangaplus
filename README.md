<div align="center">

<img src="https://github.com/hyugogirubato/mangaplus/blob/main/docs/images/MangaPlusProject.png" width="10%">

# MangaPlus

[![License](https://img.shields.io/github/license/hyugogirubato/mangaplus)](https://github.com/hyugogirubato/mangaplus/blob/main/LICENSE)
[![PyPI version](https://img.shields.io/pypi/v/mangaplus.svg)](https://pypi.org/project/mangaplus/)  
[![Python Version](https://img.shields.io/pypi/pyversions/mangaplus.svg)](https://pypi.org/project/mangaplus/)

</div>

A Python client for **MangaPlus** by Shueisha, allowing developers to access manga content and interact with the official API programmatically.

## Features

- Access all MangaPlus titles: **serializing, completed, one-shots**.
- Fetch manga chapters and downloadable images in multiple qualities.
- Manage **favorites, comments, and subscriptions**.
- Track reading history and title rankings.
- Log user interactions, including banner taps, popup taps, and downloads.
- Supports multiple languages and viewer modes (vertical/horizontal).
- Provides device registration and secure subscription handling.

## Installation

You can install via **pip**:

```bash
pip install mangaplus
````

Or install the latest version from GitHub:

```bash
pip install git+https://github.com/hyugogirubato/mangaplus.git
```

## Usage

```python
from mangaplus import MangaPlus
from mangaplus.constants import Language, Viewer, Quality, Ranking, TitleType, PageType

if __name__ == "__main__":
    # Initialize the client
    client = MangaPlus(lang=Language.ENGLISH, viewer=Viewer.VERTICAL)

    # Register a new device
    device_id = "your_device_id_here"
    client.register(device_id=device_id)

    # Fetch updates titles
    updates_content = client.getUpdates()

    # Fetch all serializing titles
    titles = client.getAllTitlesV3(title_type=TitleType.SERIALIZING)

    # Get chapter images
    chapter_data = client.getMangaData(chapter_id=1014090, quality=Quality.SUPER_HIGH)

    # Add a title to favorites
    client.addFavorited(title_id=100191)

    # Post a comment
    client.postComment(chapter_id=1014090, body="Great chapter!")
```

## API Methods

Some of the key methods provided by this client:

| Method                                             | Description                                                     |
|----------------------------------------------------|-----------------------------------------------------------------|
| `getAllTitlesV3()`                                 | Get titles by type (serializing, completed, one-shots)          |
| `getMangaData()`                                   | Retrieve chapter images with optional quality and split options |
| `getTitleDetail()`                                 | Get detailed title information                                  |
| `getFavoriteTitles()`                              | List all favorite titles                                        |
| `addFavorited()` / `deleteFavorite()`              | Add or remove titles from favorites                             |
| `postComment()` / `banComment()` / `likeComment()` | Manage comments and likes                                       |
| `register()`                                       | Register a device and obtain a secret key                       |
| `setSubscription()` / `setSubscriptionRestore()`   | Manage subscription data                                        |
| `getRankingV2()`                                   | Get ranking lists (hottest, trending, completed)                |
| `getHistory()`                                     | Retrieve user reading history                                   |
| `logBannerTap()` / `logPopupTap()`                 | Log interactions with banners and popups                        |

> And many more methods for publisher news, downloadable images, language preferences, and event logging.

## Disclaimer

**MangaPlus Python Client** is an unofficial library and is **not affiliated** with or endorsed by Shueisha. The library is provided "as-is" without any warranty, and usage is at your own risk. Please comply with the MangaPlus service terms and conditions while using this library.

## License

This project is licensed under the **GNU License**. See the [LICENSE](https://github.com/hyugogirubato/mangaplus/blob/main/LICENSE) file for details.

---

© hyugogirubato 2025