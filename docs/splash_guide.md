# Android 12+ SplashScreen API: Enterprise Implementation Guide

This document outlines how the modern Android SplashScreen API (`androidx.core:core-splashscreen`) is implemented in **GroovePlay** and how it scales for large-scale enterprise applications.

## 1. Why the New API?
Legacy custom splash screens (Activities that start, show a logo, then navigate) cause "double-starts" and flickering. The new API integrates directly with the system's launch sequence, providing:
- **Zero Flickering**: The system window transitions directly into the app.
- **Better Performance**: Reduced cold-start latency.
- **Consistent Branding**: Enforced circular icon mask and centered branding.

## 2. Enterprise-Grade Implementation in GroovePlay

### A. Dependency Management
We use the Jetpack Compat library to ensure consistent behavior from Android 6.0 (API 23) through the latest versions.
```kotlin
implementation(libs.androidx.core.splashscreen)
```

### B. The "Keep On Screen" Logic
In enterprise apps, you often need to fetch config, check auth, or warm up caches before showing the first frame. GroovePlay uses a `StateFlow` in `SplashViewModel` to control this:

```kotlin
// In MainActivity.kt
installSplashScreen().apply {
    setKeepOnScreenCondition {
        !splashViewModel.isReady.value
    }
}
```

### C. Theming for Scale
We separate the "Starting" theme from the "Main" app theme. This allows the system to render the splash before a single line of Kotlin code even runs.

- **Theme.App.Starting**: Inherits from `Theme.SplashScreen`. Configures `windowSplashScreenBackground` and `windowSplashScreenAnimatedIcon`.
- **Post-Launch**: Automatically switches to `Theme.Grooveplay` via `postSplashScreenTheme`.

## 3. Best Practices for Large Applications

| Feature | Enterprise Best Practice |
| :--- | :--- |
| **Duration** | Use `setKeepOnScreenCondition` for real work (auth/config), not artificial delays. |
| **Branding** | Use high-quality **Vector Drawables (AVD)**. Avoid bitmaps to prevent blurring on high-DPI screens. |
| **Exit Animation** | For a premium feel, customize the exit transition (e.g., slide up or fade out) using `setOnExitAnimationListener`. |
| **Icon Safety** | Keep all branding within the **inner 160dp** of the icon area to avoid clipping by the circular mask. |

## 4. Troubleshooting
- **Text Clipping**: Ensure the wordmark is scaled down. Android masks the 200dp area to a circle.
- **Dark Mode Support**: Always provide a `values-night` version of your splash theme to avoid "blinding" users at night.
- **Animated Vector Drawables**: Keep animations under 1000ms for the best user experience.
