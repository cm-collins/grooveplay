package com.example.grooveplay.core.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val GrooveplayDarkColorScheme = darkColorScheme(
    primary = Primary,
    onPrimary = Color.Black,
    secondary = Green,
    onSecondary = Color.Black,
    tertiary = DarkAccentRose,
    background = DarkBackground,
    surface = DarkCard,
    onBackground = DarkTextPrimary,
    onSurface = DarkTextPrimary,
    onSurfaceVariant = DarkTextSecondary,
    outline = DarkBorder,
    surfaceContainer = DarkElevated
)

private val GrooveplayLightColorScheme = lightColorScheme(
    primary = Primary,
    onPrimary = Color.White,
    secondary = Green,
    onSecondary = Color.White,
    tertiary = LightAccentRose,
    background = LightBackground,
    surface = LightCard,
    onBackground = LightTextPrimary,
    onSurface = LightTextPrimary,
    onSurfaceVariant = LightTextSecondary,
    outline = LightBorder,
    surfaceContainer = LightElevated
)

@Composable
fun GrooveplayTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) GrooveplayDarkColorScheme else GrooveplayLightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = GrooveplayTypography,
        content = content
    )
}
