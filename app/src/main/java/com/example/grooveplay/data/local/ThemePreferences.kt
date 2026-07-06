package com.example.grooveplay.data.local

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.grooveplay.viewmodel.ThemeMode
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.themeDataStore by preferencesDataStore(name = "theme_prefs")


/**
 * Persists the user's theme selection (Profile > Appearance > Theme) to disk.
 * This is the only place in the app that knows DataStore exists — the
 * ViewModel talks to this class, never to DataStore directly.
 */

class ThemePreferences(private val context: Context) {
    private val themekey = stringPreferencesKey("theme_mode")

    /** Emits the saved theme every time it changes. Defaults to SYSTEM if never set. */
    val themeMode: Flow<ThemeMode> = context.themeDataStore.data.map { prefs ->
        when (prefs[themekey]) {
            ThemeMode.LIGHT.name -> ThemeMode.LIGHT
            ThemeMode.DARK.name -> ThemeMode.DARK
            else -> ThemeMode.SYSTEM

        }
    }

    suspend fun setThemeMode(mode: ThemeMode) {
        context.themeDataStore.edit { prefs ->
            prefs[themekey] = mode.name
        }
    }

}