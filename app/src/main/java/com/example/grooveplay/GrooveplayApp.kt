package com.example.grooveplay

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.rememberNavController
import com.example.grooveplay.core.model.ThemeMode
import com.example.grooveplay.core.ui.theme.GrooveplayTheme
import com.example.grooveplay.core.ui.viewmodel.ThemeViewModel
import com.example.grooveplay.feature.splash.viewmodel.SplashViewModel
import com.example.grooveplay.navigation.GrooveWaveNavGraph

@Composable
fun GrooveplayApp(
    splashViewModel: SplashViewModel,
    themeViewModel: ThemeViewModel = hiltViewModel()
) {
    val themeMode by themeViewModel.themeMode.collectAsStateWithLifecycle()
    val isThemeLoaded by themeViewModel.isThemeLoaded.collectAsStateWithLifecycle()

    if (!isThemeLoaded) return

    val darkTheme = when (themeMode) {
        ThemeMode.LIGHT -> false
        ThemeMode.DARK -> true
        ThemeMode.SYSTEM -> isSystemInDarkTheme()
    }

    GrooveplayTheme(darkTheme = darkTheme) {
        val navController = rememberNavController()
        val isOnboardingCompleted by splashViewModel.isOnboardingCompleted.collectAsStateWithLifecycle()

        isOnboardingCompleted?.let { completed ->
            GrooveWaveNavGraph(
                navController = navController,
                isOnboardingCompleted = completed
            )
        }
    }
}
