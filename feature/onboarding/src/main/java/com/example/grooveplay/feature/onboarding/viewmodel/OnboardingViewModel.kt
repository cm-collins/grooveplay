package com.example.grooveplay.feature.onboarding.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.grooveplay.core.domain.usecase.SetOnboardingCompletedUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel for the Onboarding screen.
 */
@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val setOnboardingCompletedUseCase: SetOnboardingCompletedUseCase
) : ViewModel() {

    /**
     * Persists the onboarding completion state.
     */
    fun completeOnboarding() {
        viewModelScope.launch {
            setOnboardingCompletedUseCase(completed = true)
        }
    }
}
