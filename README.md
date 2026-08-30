# OReplay App

A **Kotlin Multiplatform (KMP)** application for following live and historical orienteering results using the [OReplay API](https://oreplay.es/).

## About

**OReplay App** is a Kotlin Multiplatform app for following orienteering competitions and results on Android and iOS devices, offering a polished and native experience.

## Screenshots

To Be Added

## Supported Platforms

| Platform | Status                 |
| -------- | ---------------------- |
| Android  | Available              |
| iOS      | Not currently released |

## Download

### Android

[Download the APK](https://github.com/diegopalvarez/OReplay/releases)

### iOS

The iOS version is currently not available.

## Architecture

Thanks to Kotlin Multiplatform, most of the code for the app is shared between platforms, meaning that most of the application is written in Kotlin in the shared code package.

Although the app is currently released only for Android, the shared code is already structured to support iOS. Running the iOS version requires a macOS device with Xcode.

## OReplay API

The application retrieves orienteering data from the **OReplay API**.

API documentation: **[OReplay API documentation](https://oreplay.es/api/v1/openapi/)**

## Tech Stack

| Technology                                                                            | Purpose                  |
| ------------------------------------------------------------------------------------- | ------------------------ |
| [Kotlin Multiplatform](https://www.jetbrains.com/kotlin-multiplatform/)               | Shared application logic |
| [Compose Multiplatform](https://www.jetbrains.com/compose-multiplatform/)             | Cross-platform UI        |
| [Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html)             | Asynchronous programming |
| [Kotlin Serialization](https://kotlinlang.org/docs/serialization.html)                | JSON serialization       |
| [Ktor](https://ktor.io/)                                                              | HTTP client              |
| [Koin](https://insert-koin.io/)                                                       | Dependency injection     |
| [Decompose](https://arkivanov.github.io/Decompose/)                                   | Navigation               |
| [SQLDelight](https://sqldelight.github.io/sqldelight/latest/)                         | Local persistence        |
| [DataStore Preferences](https://developer.android.com/kotlin/multiplatform/datastore) | Local preferences        |
| [assertk](https://github.com/assertk-org/assertk)                                     | Shared testing           |

## Roadmap

### Implemented

* [x] OReplay API integration
* [x] Classic events with start times, results, result tickets, and splits
* [x] Score events with results, result tickets, and detailed points view
* [x] One-Man Relay events with start times, results, and result tickets
* [x] Relay events with results, leg result tickets, and leg result details (including accumulated times and positions for each leg)
* [x] Overall events with results for point-based and time-based overalls
* [x] Live result updates for live events with a customizable refresh interval
* [x] Event search and class/club search within a stage
* [x] Multi-language support: Spanish and English
* [x] Automatic timezone conversion (with a configuration to toggle it off)
* [x] Dark and light themes

### Planned

* [ ] Radio controls integration
* [ ] Runner and club favorites
* [ ] Offline support (with cached results)
* [ ] Statistics screen for Classic events
* [ ] Deep links to redirect pages from the web to the app

## Contributing

Contributions, ideas, bug reports, and feature requests are welcome!

### Development workflow

To be specified

## Issues & Feature Requests

If you find a bug or have an idea for improving the app, please [open an issue](../../issues).

When reporting a bug, include:

* Platform and OS version
* App version
* Steps to reproduce
* Expected behavior
* Actual behavior
* Relevant logs or screenshots

## License

To be specified
