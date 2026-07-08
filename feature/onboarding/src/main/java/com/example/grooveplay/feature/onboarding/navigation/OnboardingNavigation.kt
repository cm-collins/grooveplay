package com.example.grooveplay.feature.onboarding.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.grooveplay.feature.onboarding.ui.OnboardingScreen

const val ONBOARDING_ROUTE = "onboarding"

fun NavGraphBuilder.onboardingScreen(onFinished: () -> Unit) {
    composable(route = ONBOARDING_ROUTE) {
        OnboardingScreen(onFinished = onFinished)
    }
}
