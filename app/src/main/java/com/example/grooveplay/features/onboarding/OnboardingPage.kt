package com.example.grooveplay.features.onboarding

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import com.example.grooveplay.R
import com.example.grooveplay.ui.theme.Primary
import com.example.grooveplay.ui.theme.DarkAccentRose
import com.example.grooveplay.ui.theme.Amber

/**
 * Data model for an onboarding slide.
 *
 * @property title The main headline for the slide.
 * @property description Detailed text explaining the feature.
 * @property imageRes The drawable resource ID for the illustration.
 * @property themeColor The specific accent color for this slide, using centralized tokens.
 */
data class OnboardingPage(
    val title: String,
    val description: String,
    @param:DrawableRes val imageRes: Int,
    val themeColor: Color,
)

/**
 * The static list of slides shown during the first app launch.
 * Colors are pulled directly from Color.kt to ensure consistency.
 */
val onboardingPages = listOf(
    OnboardingPage(
        title = "Your Music Library",
        description = "Browse all your local tracks by artist, album or playlist — always available offline, no internet needed.",
        imageRes = R.drawable.onboarding1,
        themeColor = Primary, // Violet
    ),
    OnboardingPage(
        title = "Stunning Player UI",
        description = "Watch your vinyl spin in real time. Animated waveforms pulse with every beat, and the seek bar flows beautifully.",
        imageRes = R.drawable.onboarding2,
        themeColor = DarkAccentRose, // Rose/Pink
    ),
    OnboardingPage(
        title = "Waveforms & Themes",
        description = "Watch your music come alive. Switch between dark and light mode — GrooveWave looks great either way.",
        imageRes = R.drawable.onboarding3,
        themeColor = Amber, // Amber
    ),
)
