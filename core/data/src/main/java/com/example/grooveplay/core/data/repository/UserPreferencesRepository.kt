package com.example.grooveplay.core.data.repository

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.grooveplay.core.model.ThemeMode
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(name = "user_prefs")

/**
 * DataStore-backed implementation of [UserRepository].
 */
class UserPreferencesRepository(private val context: Context) : UserRepository {

    private object PreferencesKeys {
        val THEME_MODE = stringPreferencesKey("theme_mode")
        val ONBOARDING_COMPLETED = booleanPreferencesKey("onboarding_completed")
    }

    override val themeMode: Flow<ThemeMode> = context.dataStore.data.map { prefs ->
        when (prefs[PreferencesKeys.THEME_MODE]) {
            ThemeMode.LIGHT.name -> ThemeMode.LIGHT
            ThemeMode.DARK.name -> ThemeMode.DARK
            else -> ThemeMode.SYSTEM
        }
    }

    override val isOnboardingCompleted: Flow<Boolean> = context.dataStore.data.map { prefs ->
        prefs[PreferencesKeys.ONBOARDING_COMPLETED] ?: false
    }

    override suspend fun setThemeMode(mode: ThemeMode) {
        context.dataStore.edit { prefs ->
            prefs[PreferencesKeys.THEME_MODE] = mode.name
        }
    }

    override suspend fun saveOnboardingCompleted(completed: Boolean) {
        context.dataStore.edit { prefs ->
            prefs[PreferencesKeys.ONBOARDING_COMPLETED] = completed
        }
    }
}
