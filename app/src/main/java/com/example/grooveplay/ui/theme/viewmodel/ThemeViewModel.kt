package com.example.grooveplay.ui.theme.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.grooveplay.data.local.UserPreferences
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

/**
 * The three theme options exposed in Profile > Appearance > Theme.
 */
enum class ThemeMode {
    SYSTEM, LIGHT, DARK
}

/**
 * Holds the app's current theme selection as UI state, backed by DataStore.
 */
class ThemeViewModel(application: Application) : AndroidViewModel(application) {

    private val preferences = UserPreferences(application)

    private val _themeMode = MutableStateFlow(ThemeMode.SYSTEM)
    val themeMode: StateFlow<ThemeMode> = _themeMode.asStateFlow()

    private val _isThemeLoaded = MutableStateFlow(value = false)
    val isThemeLoaded: StateFlow<Boolean> = _isThemeLoaded.asStateFlow()

    init {
        viewModelScope.launch {
            preferences.themeMode
                .catch { emit(ThemeMode.SYSTEM) }
                .collect { mode ->
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
