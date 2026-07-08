package com.example.grooveplay.feature.onboarding.ui

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

/**
 * Data model for an onboarding slide.
 */
data class OnboardingPage(
    val title: String,
    val description: String,
    @param:DrawableRes val imageRes: Int,
    val themeColor: Color,
)

/**
 * The static list of slides shown during the first app launch.
 */
val onboardingPages = listOf(
    OnboardingPage(
        title = "Your Music Library",
        description = "Browse all your local tracks by artist, album or playlist — always available offline, no internet needed.",
        imageRes = com.example.grooveplay.core.ui.R.drawable.onboarding1,
        themeColor = Color(0xFF754AF6), // Primary
    ),
    OnboardingPage(
        title = "Stunning Player UI",
        description = "Watch your vinyl spin in real time. Animated waveforms pulse with every beat, and the seek bar flows beautifully.",
        imageRes = com.example.grooveplay.core.ui.R.drawable.onboarding2,
        themeColor = Color(0xFFFD638B), // DarkAccentRose
    ),
    OnboardingPage(
        title = "Waveforms & Themes",
        description = "Watch your music come alive. Switch between dark and light mode — GrooveWave looks great either way.",
        imageRes = com.example.grooveplay.core.ui.R.drawable.onboarding3,
        themeColor = Color(0xFFFFB73D), // Amber
    ),
)
