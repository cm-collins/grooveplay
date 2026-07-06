package com.example.grooveplay.ui.theme

import androidx.compose.ui.graphics.Color

// ─────────────────────────────────────────────
// Raw design tokens (from Figma "Design Tokens" frame)
// These are the source-of-truth values. Never reference
// hardcoded hex codes anywhere else in the app — always
// go through these, or better, through MaterialTheme.colorScheme
// once wired up in Theme.kt.
// ─────────────────────────────────────────────

// Shared brand colors (identical in both themes)
val Primary = Color(0xFF754AF6)        // Violet — buttons, active states, progress
val PrimaryLight = Color(0xFF9C7EFD)   // Lighter violet — seek bar thumb, secondary accents
val Amber = Color(0xFFFFB73D)          // Warm accent — used sparingly (badges, highlights)
val Green = Color(0xFF42DB88)          // Success / positive state

// ---------- Dark theme tokens ----------
val DarkBackground = Color(0xFF0C0C12)
val DarkCard = Color(0xFF15151E)
val DarkElevated = Color(0xFF1C1C28)
val DarkSurface = Color(0xFF232332)
val DarkAccentRose = Color(0xFFFD638B)
val DarkTextPrimary = Color(0xFFF3F3FA)
val DarkTextSecondary = Color(0xFF8F8FA6)
val DarkBorder = Color(0xFF2E2E41)

// ---------- Light theme tokens ----------
val LightBackground = Color(0xFFF6F6FA)
val LightCard = Color(0xFFFFFFFF)
val LightElevated = Color(0xFFEFEFF4)
val LightSurface = Color(0xFFE5E5ED)
val LightAccentRose = Color(0xFFE53372)
val LightAmber = Color(0xFFEE9911)
val LightTextPrimary = Color(0xFF1A1A28)
val LightTextSecondary = Color(0xFF6B6B80) // muted gray derived to match light-theme contrast; adjust if Figma adds an explicit token
val LightBorder = Color(0xFFD8D8E3)