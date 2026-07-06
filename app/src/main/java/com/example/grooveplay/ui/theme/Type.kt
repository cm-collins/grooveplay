package com.example.grooveplay.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// NOTE: Figma specifies "Inter" as the typeface. Using FontFamily.Default
// (Roboto) for now so the project builds immediately. To match Figma
// exactly, add the Inter font files under res/font/ and swap
// FontFamily.Default for FontFamily(Font(R.font.inter_regular), ...).
// Everything else (sizes, weights) already matches the Design Tokens frame.

val GrooveplayTypography = Typography(
    // "Heading / Bold 28" — screen titles like "My Library"
    headlineMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp,
    ),
    // "Title / Semi Bold 18" — section headers, card titles
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp,
    ),
    titleMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
    ),
    // "Body / Regular 14" — track titles, body text
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
    ),
    bodyMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 13.sp,
    ),
    // "Caption / Regular 11" — timestamps, secondary metadata
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 11.sp,
    ),
    labelMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
    ),
)