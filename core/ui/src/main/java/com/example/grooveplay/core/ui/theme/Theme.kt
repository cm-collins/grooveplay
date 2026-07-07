package com.example.grooveplay.core.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val GrooveplayDarkColorScheme = darkColorScheme(
    primary = Primary,
    onPrimary = Color.White,
    primaryContainer = DarkSurface,
    onPrimaryContainer = DarkTextPrimary,
    secondary = PrimaryLight,
    onSecondary = Color.White,
    tertiary = Amber,
    onTertiary = Color.Black,
    background = DarkBackground,
    onBackground = DarkTextPrimary,
    surface = DarkCard,
    onSurface = DarkTextPrimary,
    surfaceVariant = DarkSurface,
    onSurfaceVariant = DarkTextSecondary,
    surfaceTint = Primary,
    error = DarkAccentRose,
    onError = Color.White,
    outline = DarkBorder,
    outlineVariant = DarkElevated,
)

private val GrooveplayLightColorScheme = lightColorScheme(
    primary = Primary,
    onPrimary = Color.White,
    primaryContainer = LightSurface,
    onPrimaryContainer = LightTextPrimary,
    secondary = PrimaryLight,
    onSecondary = Color.White,
    tertiary = LightAmber,
    onTertiary = Color.White,
    background = LightBackground,
    onBackground = LightTextPrimary,
    surface = LightCard,
    onSurface = LightTextPrimary,
    surfaceVariant = LightSurface,
    onSurfaceVariant = LightTextSecondary,
    surfaceTint = Primary,
    error = LightAccentRose,
    onError = Color.White,
    outline = LightBorder,
    outlineVariant = LightElevated,
)

@Composable
fun GrooveplayTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colorScheme = if (darkTheme) GrooveplayDarkColorScheme else GrooveplayLightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = GrooveplayTypography,
        content = content,
    )
}
