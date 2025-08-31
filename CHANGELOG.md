# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/), and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [1.23.1] - 2025-08-31

### Added

- Parser script to convert Java `*.class` files to Protocol Buffers (`.proto`).
- README section explaining the conversion process from compiled protobuf (`.pb`) to `.proto` format.
- Language references included in graphic/UI components.
- Auto-completion support for protobuf objects via `mypy-protobuf`.
- Several new API and utility functions added.

### Changed

- Unified builder script now generates a single consolidated protobuf prototype file.
- Updated protobuf definitions to the latest format.
- Removed redundant or obsolete functions to streamline the codebase.
- Updated README to reflect recent API and project changes.
- Automatic function renaming implemented
  through [retropy.py](https://gist.github.com/hyugogirubato/e4e602f2d135622fa5a3f889c0726ce3)

### Fixed

- Corrected invalid enum values being passed as parameters.
- Fixed language references in graphic/UI components.
- Resolved dependency issues in `pyproject.toml`.
- Corrected license type declaration for the project.

## [1.9.19] - 2024-06-10

### Added

- Full refactor of the client code.
- Implemented support for new API endpoints.
- Added detailed error handling.
- Added support for multiple languages.
- New methods for managing user profile and comments.

### Changed

- Migrated project to use Poetry for dependency management.
- Updated documentation with new usage examples and installation instructions.
- Improved the handling of API parameters and headers.

### Fixed

- Various bug fixes and performance improvements.

## [1.1.4] - 2024-03-10

### Changed

- Update app version.

## [1.1.3] - 2023-07-23

### Changed

- Proto timestamp to uint32.

### Fixed

- Invalid shared value `secret`.

## [1.1.2] - 2023-06-11

### Fixed

- Headers parameter.

### Changed

- Class renamed to `Client`.

## [1.1.1] - 2023-06-09

### Changed

- Updated `README`.

## [1.1.0] - 2023-06-09

### Changed

- Project renamed to `pymangaplus`.
- Class name changed.
- `api` and `secret` variable now public.

## [1.0.2] - 2023-06-03

### Fixed

- Import of dependencies.

## [1.0.1] - 2023-06-02

### Changed

- Fix icon link.
- Add `pip` install.

## [1.0.0] - 2023-06-02

### Added

- Initial push.

[1.23.1]: https://github.com/hyugogirubato/mangaplus/releases/tag/v1.23.1
[1.9.19]: https://github.com/hyugogirubato/mangaplus/releases/tag/v1.9.19
[1.1.4]: https://github.com/hyugogirubato/mangaplus/releases/tag/v1.1.4
[1.1.3]: https://github.com/hyugogirubato/mangaplus/releases/tag/v1.1.3
[1.1.2]: https://github.com/hyugogirubato/mangaplus/releases/tag/v1.1.2
[1.1.1]: https://github.com/hyugogirubato/mangaplus/releases/tag/v1.1.1
[1.1.0]: https://github.com/hyugogirubato/mangaplus/releases/tag/v1.1.0
[1.0.1]: https://github.com/hyugogirubato/mangaplus/releases/tag/v1.0.2
[1.0.1]: https://github.com/hyugogirubato/mangaplus/releases/tag/v1.0.1
[1.0.0]: https://github.com/hyugogirubato/mangaplus/releases/tag/v1.0.0
