<div align="center">

<img src="https://github.com/hyugogirubato/pymangaplus/blob/main/docs/images/icon.png" width="10%">

**PyMangaPlus**

[![License](https://img.shields.io/github/license/hyugogirubato/pymangaplus)](https://github.com/hyugogirubato/pymangaplus/blob/main/LICENSE)
[![Release](https://img.shields.io/github/release-date/hyugogirubato/pymangaplus)](https://github.com/hyugogirubato/pymangaplus/releases)
[![Latest Version](https://img.shields.io/pypi/v/pymangaplus)](https://pypi.org/project/pymangaplus/)

</div>



PyMangaPlus is a Python client for the MangaPlus API, allowing you to access various manga-related information and
features. This library provides a convenient way to interact with the MangaPlus API and retrieve data such as manga
details, chapters, comments, rankings, and more.

## Features

- Retrieve manga details including title, author, description, cover image, and more.
- Get a list of available chapters for a specific manga.
- View manga chapters and read them online.
- Add or remove manga titles from your bookmarks.
- Access publisher news for specific publishers.
- View featured manga titles.
- Retrieve and update user profile information.
- View the home page with recommended manga titles.
- Like or unlike comments on manga chapters.

## Installation

You can install PyMangaPlus using pip:

````shell
pip install pymangaplus
````

## Usage

Here's an example of how to use the PyMangaPlus library:

```python
import secrets

from pymangaplus.client import MangaPlus
from pymangaplus.constants import Quality

if __name__ == "__main__":
    title_id = 100191  # 【OSHI NO KO】
    chapter_id = 1014090  # Chapter 86: ASSISTANT DIRECTOR
    android_id = secrets.token_bytes(8).hex()

    client = MangaPlus()

    # Register new device
    client.register(android_id)

    # Home titles
    content = client.home()
    print(content)

    # View manga chapters
    content = client.manga_viewer(chapter_id, quality=Quality.SUPER_HIGH)
    print(content)
```

For more information on how to use PyMangaPlus, please refer to
the [documentation](https://github.com/hyugogirubato/pymangaplus/blob/main/docs).

## Disclaimer

PyMangaPlus is an unofficial library and is not affiliated with or endorsed by MangaPlus or Shueisha. The library is
provided "as is" without any warranty, and the usage of this library is at your own risk. Make sure to comply with the
terms and conditions of the MangaPlus service while using this library.

### License

This project is licensed under the [GPL v3 License](https://github.com/hyugogirubato/pymangaplus/blob/main/LICENSE).