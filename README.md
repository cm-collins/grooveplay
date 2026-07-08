# GroovePlay 🎵

A premium music distribution and streaming platform built with modern Android technologies, featuring a scalable multi-module architecture.

## 🏗️ Architecture

GroovePlay is built using **Clean Architecture** principles and a **Multi-Module** setup to ensure scalability, maintainability, and clear separation of concerns.

### Module Structure

- **`:app`**: The entry point. Handles app initialization, dependency injection (Hilt), and global navigation coordination.
- **`:feature:*`**: Encapsulated UI features. Each feature owns its ViewModels and navigation logic.
    - `:feature:home`: Main dashboard with track listings and recommendations.
    - `:feature:onboarding`: Interactive first-launch experience.
    - `:feature:splash`: App launch logic and destination routing.
- **`:core:*`**: Shared business logic and UI components.
    - `:core:domain`: UseCases and business rules.
    - `:core:data`: Repositories and data sources (DataStore, local/remote).
    - `:core:model`: Shared data structures and Enums (e.g., `ThemeMode`).
    - `:core:ui`: Common UI components, Theme, and shared ViewModels (e.g., `ThemeViewModel`).
    - `:core:common`: Utility classes and extensions.

## 🚀 Key Features

- **Premium UI/UX**: Built with **Jetpack Compose** and **Material 3**. Includes official Android 12+ `SplashScreen` integration.
- **Modular Navigation**: Decoupled navigation where each feature module defines its own graph via `NavGraphBuilder` extensions.
- **Theme Management**: Persistent dark/light mode support using **DataStore** and a centralized `ThemeViewModel`.
- **Modern DI**: Robust dependency injection with **Hilt** and **KSP**.

## 🛠️ Technical Stack

- **UI**: Jetpack Compose (Material 3)
- **Architecture**: MVVM + Clean Architecture + Multi-Module
- **DI**: Hilt (Dagger Hilt)
- **Concurrency**: Kotlin Coroutines & Flow
- **Persistence**: DataStore Preferences
- **Build System**: Gradle Kotlin DSL + Version Catalogs (TOML) + KSP

## 📖 Documentation
- [Multi-Module Refactoring Walkthrough](docs/walkthrough.md) - Summary of the architectural transition.
- [Enterprise SplashScreen Guide](docs/splash_guide.md) - Deep dive into high-end app launches.

---
*Built with ❤️ for Android Mobile Engineering.*
