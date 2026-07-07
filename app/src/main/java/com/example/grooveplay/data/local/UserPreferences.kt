package com.example.grooveplay.data.local

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.grooveplay.ui.viewmodel.ThemeMode
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.themeDataStore by preferencesDataStore(name = "theme_prefs")

/**
 * Persists user preferences to disk using Jetpack DataStore.
 */
class UserPreferences(private val context: Context) {
    
    private val themeKey = stringPreferencesKey("theme_mode")
    private val onboardingCompletedKey = booleanPreferencesKey("onboarding_completed")

    /** Emits the saved theme mode. Defaults to SYSTEM. */
    val themeMode: Flow<ThemeMode> = context.themeDataStore.data.map { prefs ->
        when (prefs[themeKey]) {
            ThemeMode.LIGHT.name -> ThemeMode.LIGHT
            ThemeMode.DARK.name -> ThemeMode.DARK
            else -> ThemeMode.SYSTEM
        }
    }

    /** Emits true if onboarding has been completed. */
    val isOnboardingCompleted: Flow<Boolean> = context.themeDataStore.data.map { preferences ->
        preferences[onboardingCompletedKey] ?: false
    }

    /** Updates the theme mode in DataStore. */
    suspend fun setThemeMode(mode: ThemeMode) {
        context.themeDataStore.edit { prefs ->
            prefs[themeKey] = mode.name
        }
    }

    /** Updates the onboarding completion state in DataStore. */
    suspend fun saveOnboardingCompleted(completed: Boolean) {
        context.themeDataStore.edit { preferences ->
            preferences[onboardingCompletedKey] = completed
        }
    }
}
