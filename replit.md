# Orbot — Android Onion Routing Robot

## Project Overview

Orbot is an open-source Android application developed by the Guardian Project. It acts as a front-end for the Tor binary, routing Android device traffic through the Tor network for privacy and anonymity. It supports VPN mode, bridge configurations, and Onion Services (v3).

- **Website:** https://orbot.app
- **License:** Open Source (see LICENSE)
- **Copyright:** 2009–2025, Nathan Freitas, The Guardian Project

## Tech Stack

- **Language:** Kotlin (2.2.0) + some legacy Java
- **Platform:** Android (Min SDK 24, Target SDK 36)
- **Build System:** Gradle (Kotlin DSL for settings, Groovy DSL for modules)
- **Dependency Management:** Gradle Version Catalogs (`gradle/libs.versions.toml`)
- **CI/CD:** Fastlane + Bitrise

## Project Structure

```
app/             — Main Android app module (UI, Activities, Fragments, ViewModels)
orbotservice/    — Background Tor service, VPN logic, Tor process management
OrbotLib/        — Local library (native binaries, tor integration)
gradle/          — Gradle wrapper and version catalog
docs/            — Design specs and build documentation
fastlane/        — Play Store metadata and release automation
scripts/         — Translation, bridge update, and release scripts
```

## Important Note for Replit

**This is a native Android application.** It cannot be run or previewed in Replit's browser-based environment. To build and run this project you need:

- Android Studio (or Android SDK command-line tools)
- An Android device or emulator
- Java 17+

To build an APK:
```bash
./gradlew assembleDebug
```

The resulting APK will be in `app/build/outputs/apk/debug/`.

## User Preferences

(Add any preferences here as they are established.)
