package com.example.grooveplay.feature.splash.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.grooveplay.core.domain.usecase.GetOnboardingStatusUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.time.Duration.Companion.milliseconds

private const val MIN_SPLASH_VISIBLE_MS = 2000L

/**
 * Manages the splash screen logic and determines the initial app destination.
 */
@HiltViewModel
class SplashViewModel @Inject constructor(
    private val getOnboardingStatusUseCase: GetOnboardingStatusUseCase
) : ViewModel() {

    private val _isReady = MutableStateFlow(value = false)
    val isReady: StateFlow<Boolean> = _isReady.asStateFlow()

    private val _isOnboardingCompleted = MutableStateFlow<Boolean?>(value = null)
    val isOnboardingCompleted: StateFlow<Boolean?> = _isOnboardingCompleted.asStateFlow()

    init {
        initialize()
    }

    private fun initialize() {
        viewModelScope.launch {
            try {
                // 1. Fetch onboarding state via UseCase
                val completed = getOnboardingStatusUseCase().first()
                _isOnboardingCompleted.value = completed

                // 2. Wait for minimum splash time
                delay(MIN_SPLASH_VISIBLE_MS.milliseconds)
            } finally {
                // 3. Mark app as ready
                _isReady.value = true
            }
        }
    }
}
