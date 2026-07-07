package com.example.grooveplay.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.grooveplay.features.home.screens.HomeScreen
import com.example.grooveplay.features.onboarding.OnboardingScreen

/**
 * Main navigation graph for the application.
 *
 * @param navController The navigation controller to manage app navigation.
 * @param startDestination The initial screen to display (Home or Onboarding).
 * @param onOnboardingFinished Callback executed when the user completes onboarding.
 */
@Composable
fun GrooveWaveNavGraph(
    navController: NavHostController,
    startDestination: String,
    onOnboardingFinished: () -> Unit,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
    ) {
        composable(Routes.ONBOARDING) {
            OnboardingScreen(
                onFinished = {
                    onOnboardingFinished()
                    navController.navigate(Routes.HOME) {
                        // Remove onboarding from backstack so users can't navigate back to it
                        popUpTo(Routes.ONBOARDING) {
                            inclusive = true
                        }
                    }
                },
            )
        }

        composable(Routes.HOME) {
            HomeScreen()
        }
    }
}
