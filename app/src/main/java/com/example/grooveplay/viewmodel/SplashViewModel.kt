package com.example.grooveplay.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.milliseconds

// A small, deliberate minimum so the brand mark isn't a single-frame flash
// on fast devices. This is NOT a fake "loading" delay — it runs alongside
// real readiness checks below, not instead of them. As the app grows
// (auth session check, cached-library warm-up, etc.), add those checks
// here too; isReady should only flip once everything is actually ready.
private const val MIN_SPLASH_VISIBLE_MS = 2000L

class SplashViewModel : ViewModel() {
    private val _isReady = MutableStateFlow(false)
    val isReady: StateFlow<Boolean> = _isReady.asStateFlow()

    init {
        viewModelScope.launch {
            delay(MIN_SPLASH_VISIBLE_MS)
            _isReady.value = true
        }
    }
}