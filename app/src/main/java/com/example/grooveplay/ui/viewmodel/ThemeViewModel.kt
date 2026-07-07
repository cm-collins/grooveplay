package com.example.grooveplay.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.grooveplay.core.data.repository.UserPreferencesRepository
import com.example.grooveplay.core.data.repository.UserRepository
import com.example.grooveplay.core.model.ThemeMode
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * Holds the app's current theme selection as UI state.
 */
class ThemeViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: UserRepository = UserPreferencesRepository(application)

    private val _themeMode = MutableStateFlow(ThemeMode.SYSTEM)
    val themeMode: StateFlow<ThemeMode> = _themeMode.asStateFlow()

    private val _isThemeLoaded = MutableStateFlow(value = false)
    val isThemeLoaded: StateFlow<Boolean> = _isThemeLoaded.asStateFlow()

    init {
        viewModelScope.launch {
            repository.themeMode.collect { mode ->
                _themeMode.value = mode
                _isThemeLoaded.value = true
            }
        }
    }

    fun setThemeMode(mode: ThemeMode) {
        _themeMode.value = mode
        viewModelScope.launch {
            repository.setThemeMode(mode)
        }
    }

    fun toggleDarkLight() {
        val next = if (_themeMode.value == ThemeMode.DARK) ThemeMode.LIGHT else ThemeMode.DARK
        setThemeMode(next)
    }
}
