package com.example.grooveplay.core.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.grooveplay.core.domain.usecase.GetThemeModeUseCase
import com.example.grooveplay.core.domain.usecase.SetThemeModeUseCase
import com.example.grooveplay.core.model.ThemeMode
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Holds the app's current theme selection as UI state.
 */
@HiltViewModel
class ThemeViewModel @Inject constructor(
    private val getThemeModeUseCase: GetThemeModeUseCase,
    private val setThemeModeUseCase: SetThemeModeUseCase
) : ViewModel() {

    private val _themeMode = MutableStateFlow(ThemeMode.SYSTEM)
    val themeMode: StateFlow<ThemeMode> = _themeMode.asStateFlow()

    private val _isThemeLoaded = MutableStateFlow(value = false)
    val isThemeLoaded: StateFlow<Boolean> = _isThemeLoaded.asStateFlow()

    init {
        viewModelScope.launch {
            getThemeModeUseCase().collect { mode ->
                _themeMode.value = mode
                _isThemeLoaded.value = true
            }
        }
    }

    fun setThemeMode(mode: ThemeMode) {
        _themeMode.value = mode
        viewModelScope.launch {
            setThemeModeUseCase(mode)
        }
    }

    fun toggleDarkLight() {
        val next = if (_themeMode.value == ThemeMode.DARK) ThemeMode.LIGHT else ThemeMode.DARK
        setThemeMode(next)
    }
}
