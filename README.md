<div align="center">

<img src="https://github.com/hyugogirubato/mangaplus/blob/main/docs/images/MangaPlusProject.png" width="10%">

# MangaPlus

[![License](https://img.shields.io/github/license/hyugogirubato/mangaplus)](https://github.com/hyugogirubato/mangaplus/blob/main/LICENSE)
[![Release](https://img.shields.io/github/release-date/hyugogirubato/mangaplus)](https://github.com/hyugogirubato/mangaplus/releases)
[![Latest Version](https://img.shields.io/pypi/v/mangaplus)](https://pypi.org/project/mangaplus/)

</div>

MangaPlus is a Python client for the MangaPlus API, allowing you to access various manga-related information and features. This library provides a convenient way to interact with the MangaPlus API and retrieve data such as manga details, chapters, comments, rankings, and more.

## Features

- Retrieve manga details including title, author, description, cover image, and more.
- Get a list of available chapters for a specific manga.
- View manga chapters with different quality settings.
- Add or remove manga titles from your bookmarks.
- Access publisher news for specific publishers.
- View featured manga titles.
- Retrieve and update user profile information.
- View the home page with recommended manga titles.
- Like or dislike comments on manga chapters.
- Fetch ranking lists (hottest, trending, completed).
- Manage user subscriptions and view history.

## Installation

You can install MangaPlus using pip:

```shell
pip install mangaplus
```

## Usage

Here's an example of how to use the MangaPlus library:

```python
from mangaplus.shueisha import MangaPlus, Language, Viewer, Quality

if __name__ == "__main__":
    title_id = 100191  # Example title ID
    chapter_id = 1014090  # Example chapter ID

    # Initialize the MangaPlus client with default settings
    client = MangaPlus(lang=Language.ENGLISH, viewer=Viewer.HORIZONTAL)

    # Register a new device
    device_id = "your_device_id_here"
    client.register(device_id)

    # Fetch home titles
    home_content = client.home()
    print(home_content)

    # View manga chapters
    manga_chapter = client.manga_viewer(
        chapter_id=chapter_id,
        split=True,
        quality=Quality.SUPER_HIGH
    )
    print(manga_chapter)
```

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request or open an issue on the [GitHub repository](https://github.com/hyugogirubato/mangaplus/issues).

## Disclaimer

MangaPlus is an unofficial library and is not affiliated with or endorsed by Shueisha. The library is provided "as is" without any warranty, and the usage of this library is at your own risk. Make sure to comply with the terms and conditions of the MangaPlus service while using this library.

## License

The MangaPlus library is released under the MIT License. See [LICENSE](https://github.com/hyugogirubato/mangaplus/blob/main/LICENSE) for details.
