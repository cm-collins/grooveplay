package com.example.grooveplay.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * The three theme options exposed in Profile > Appearance > Theme.
 * SYSTEM follows the device setting; LIGHT/DARK override it explicitly.
 */
enum class ThemeMode {
    SYSTEM, LIGHT, DARK
}

/**
 * Holds the app's current theme selection as UI state.
 *
 * This is the "VM" in MVVM for anything theme-related: the Composable
 * layer (View) only ever reads [themeMode] and calls [setThemeMode] —
 * it never decides theme logic itself.
 *
 * Later, persist the selection with DataStore/SharedPreferences inside
 * this ViewModel (e.g. load it in `init {}`, save it in [setThemeMode])
 * so the choice survives app restarts. Kept in-memory only for now.
 */
class ThemeViewModel : ViewModel() {

    private val _themeMode = MutableStateFlow(ThemeMode.SYSTEM)
    val themeMode: StateFlow<ThemeMode> = _themeMode.asStateFlow()

    fun setThemeMode(mode: ThemeMode) {
        _themeMode.value = mode
    }

    fun toggleDarkLight() {
        _themeMode.value = when (_themeMode.value) {
            ThemeMode.DARK -> ThemeMode.LIGHT
            ThemeMode.LIGHT -> ThemeMode.DARK
            ThemeMode.SYSTEM -> ThemeMode.DARK // first explicit tap breaks away from system
        }
    }
}