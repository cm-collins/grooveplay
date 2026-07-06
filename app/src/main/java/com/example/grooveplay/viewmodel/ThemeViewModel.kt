package com.example.grooveplay.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.grooveplay.data.local.ThemePreferences
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * The three theme options exposed in Profile > Appearance > Theme.
 * SYSTEM follows the device setting; LIGHT/DARK override it explicitly.
 */
enum class ThemeMode {
    SYSTEM, LIGHT, DARK
}

/**
 * Holds the app's current theme selection as UI state, backed by DataStore
 * so the choice survives app restarts.
 *
 * This is the "VM" in MVVM for anything theme-related: the Composable
 * layer (View) only ever reads [themeMode] / [isThemeLoaded] and calls
 * [setThemeMode] — it never touches persistence directly.
 */
class ThemeViewModel(application: Application) : AndroidViewModel(application) {

    private val preferences = ThemePreferences(application)

    private val _themeMode = MutableStateFlow(ThemeMode.SYSTEM)
    val themeMode: StateFlow<ThemeMode> = _themeMode.asStateFlow()

    // True once the first value has been read from DataStore. SplashScreen
    // waits on this so it never shows a flash of the wrong theme.
    private val _isThemeLoaded = MutableStateFlow(false)
    val isThemeLoaded: StateFlow<Boolean> = _isThemeLoaded.asStateFlow()

    init {
        viewModelScope.launch {
            preferences.themeMode.collect { mode ->
                _themeMode.value = mode
                _isThemeLoaded.value = true
            }
        }
    }

    fun setThemeMode(mode: ThemeMode) {
        _themeMode.value = mode
        viewModelScope.launch {
            preferences.setThemeMode(mode)
        }
    }

    fun toggleDarkLight() {
        val next = if (_themeMode.value == ThemeMode.DARK) ThemeMode.LIGHT else ThemeMode.DARK
        setThemeMode(next)
    }
}