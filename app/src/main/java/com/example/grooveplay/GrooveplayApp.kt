package com.example.grooveplay

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.grooveplay.features.splash.viewmodel.SplashViewModel
import com.example.grooveplay.navigation.GrooveWaveNavGraph
import com.example.grooveplay.core.ui.theme.GrooveplayTheme
import com.example.grooveplay.core.model.ThemeMode
import com.example.grooveplay.ui.viewmodel.ThemeViewModel

/**
 * Top-level Composable that orchestrates the app's theme and navigation.
 */
@Composable
fun GrooveplayApp(
    splashViewModel: SplashViewModel,
    themeViewModel: ThemeViewModel = viewModel(),
) {
    val themeMode by themeViewModel.themeMode.collectAsStateWithLifecycle()
    val startDestination by splashViewModel.startDestination.collectAsStateWithLifecycle()

    val darkTheme = when (themeMode) {
        ThemeMode.DARK -> true
        ThemeMode.LIGHT -> false
        ThemeMode.SYSTEM -> isSystemInDarkTheme()
    }

    GrooveplayTheme(darkTheme = darkTheme) {
        startDestination?.let { destination ->
            GrooveWaveNavGraph(
                navController = rememberNavController(),
                startDestination = destination,
                onOnboardingFinished = splashViewModel::completeOnboarding,
            )
        }
    }
}
