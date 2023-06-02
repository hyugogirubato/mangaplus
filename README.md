<div align="center">

<img src="./docs/icon.png" width="10%">

**MangaPlus**

[![License](https://img.shields.io/badge/License-GNU%20v3-blue.svg)](https://opensource.org/licenses/GPL-3.0)
[![Release](https://img.shields.io/github/release-date/hyugogirubato/MangaPlus)](https://github.com/hyugogirubato/MangaPlus/releases)

</div>


Python library for interacting with the MangaPlus API. This library provides convenient methods for accessing various
features of MangaPlus, such as retrieving manga settings, bookmarking titles, fetching publisher news, and more.

## Features

- Retrieve manga settings
- Initialize the client
- Bookmark titles
- Fetch publisher news
- View manga chapters
- Post and retrieve comments
- Get featured manga titles
- Register and manage user profiles
- Get ticket titles
- Access home and ranking views
- Manage push tokens
- Get free manga titles
- Retrieve detailed information about a specific title

## Installation

You can install the MangaPlus Python library using pip:

````shell
pip install mangaplus
````

## Usage

Here's a simple example of how to use the MangaPlus Python library:

````python
import secrets

from mangaplus import Client, Quality

if __name__ == "__main__":
    title_id = 100191  # 【OSHI NO KO】
    chapter_id = 1014090  # Chapter 86: ASSISTANT DIRECTOR
    android_id = secrets.token_bytes(8).hex()

    client = Client()
    client.register(android_id)

    content = client.home()
    print(content)

    content = client.manga_viewer(chapter_id, quality=Quality.SUPER_HIGH)
    print(content)
````

## Credit

- Manga Plus Icon &copy; Shueisha Inc.

## License

[GNU General Public License, Version 3.0](LICENSE)
