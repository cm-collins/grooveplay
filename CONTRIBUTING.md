# Contributing to GroovePlay

Thank you for your interest in contributing to GroovePlay! This document provides guidelines for contributing to the project.

## 🏗️ Architectural Guidelines

We follow **Clean Architecture** and a **Multi-Module** approach. When adding new features or logic, please adhere to the following:

1.  **Modularization**: 
    - New UI features should go into a new `:feature:<name>` module.
    - Features should be independent and not depend on other feature modules.
    - Shared logic should be placed in the appropriate `:core:*` module.

2.  **Clean Architecture**:
    - **UI Layer**: ViewModels and Composable screens.
    - **Domain Layer**: Pure Kotlin UseCases that encapsulate business logic.
    - **Data Layer**: Repositories and DataSources. Repositories should be accessed via interfaces.

3.  **Navigation**:
    - Define feature navigation in a `navigation` package within the feature module using `NavGraphBuilder` extensions.
    - Keep route constants internal to the navigation file or module.

4.  **Dependency Injection**:
    - Use **Hilt** for DI.
    - Annotate ViewModels with `@HiltViewModel`.
    - Provide dependencies via Hilt Modules in the `di` package of the respective module.

## 🛠️ Development Workflow

1.  **Branching**: Create a feature branch from `main`.
2.  **Code Style**: Follow standard Kotlin coding conventions.
3.  **Build**: Ensure the app builds successfully before submitting changes:
    ```bash
    ./gradlew assembleDebug
    ```
4.  **Testing**: Run unit tests for any logic changes:
    ```bash
    ./gradlew test
    ```

## 📝 Pull Request Process

- Provide a clear description of the changes.
- Include screenshots or screen recordings for UI modifications.
- Ensure all CI checks (if applicable) pass.

---
*Let's build something great together!*
