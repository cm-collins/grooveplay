package com.example.grooveplay.features.splash.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.grooveplay.data.local.UserPreferences
import com.example.grooveplay.navigation.Routes
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.milliseconds

private const val MIN_SPLASH_VISIBLE_MS = 2000L

/**
 * Manages the splash screen logic and determines the initial app destination.
 */
class SplashViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = UserPreferences(application)

    private val _isReady = MutableStateFlow(value = false)
    val isReady: StateFlow<Boolean> = _isReady.asStateFlow()

    private val _startDestination = MutableStateFlow<String?>(value = null)
    val startDestination: StateFlow<String?> = _startDestination.asStateFlow()

    init {
        initialize()
    }

    private fun initialize() {
        viewModelScope.launch {
            try {
                // 1. Fetch onboarding state first to avoid racing with splash dismissal
                val completed = repository.isOnboardingCompleted
                    .catch { emit(false) } // Fallback to false on error
                    .first()
                
                _startDestination.value = if (completed) Routes.HOME else Routes.ONBOARDING

                // 2. Wait for minimum splash time
                delay(MIN_SPLASH_VISIBLE_MS.milliseconds)
            } finally {
                // 3. Always mark app as ready to avoid infinite splash
                _isReady.value = true
            }
        }
    }

    /**
     * Persists the onboarding completion state.
     */
    fun completeOnboarding() {
        viewModelScope.launch {
            repository.saveOnboardingCompleted(completed = true)
        }
    }
}
