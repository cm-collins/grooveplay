package com.example.grooveplay.core.data.repository

import com.example.grooveplay.core.model.ThemeMode
import kotlinx.coroutines.flow.Flow

/**
 * Abstraction for user-related data operations.
 * Following the Repository Pattern to decouple data sources from domain logic.
 */
interface UserRepository {
    /** Emits the current theme mode selection. */
    val themeMode: Flow<ThemeMode>

    /** Emits true if the user has completed the onboarding flow. */
    val isOnboardingCompleted: Flow<Boolean>

    /** Persists the user's theme mode selection. */
    suspend fun setThemeMode(mode: ThemeMode)

    /** Persists the onboarding completion state. */
    suspend fun saveOnboardingCompleted(completed: Boolean)
}
