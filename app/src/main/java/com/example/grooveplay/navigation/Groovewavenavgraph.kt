package com.example.grooveplay.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.grooveplay.feature.home.navigation.HOME_ROUTE
import com.example.grooveplay.feature.home.navigation.homeScreen
import com.example.grooveplay.feature.onboarding.navigation.ONBOARDING_ROUTE
import com.example.grooveplay.feature.onboarding.navigation.onboardingScreen

/**
 * Main navigation graph for the application.
 */
@Composable
fun GrooveWaveNavGraph(
    navController: NavHostController,
    isOnboardingCompleted: Boolean,
) {
    NavHost(
        navController = navController,
        startDestination = if (isOnboardingCompleted) HOME_ROUTE else ONBOARDING_ROUTE,
    ) {
        onboardingScreen(
            onFinished = {
                navController.navigate(HOME_ROUTE) {
                    popUpTo(ONBOARDING_ROUTE) {
                        inclusive = true
                    }
                }
            },
        )

        homeScreen()
    }
}
