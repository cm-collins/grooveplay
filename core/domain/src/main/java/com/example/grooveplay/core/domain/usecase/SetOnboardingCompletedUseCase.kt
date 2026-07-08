package com.example.grooveplay.core.domain.usecase

import com.example.grooveplay.core.data.repository.UserRepository
import javax.inject.Inject

/**
 * UseCase to mark the onboarding flow as completed.
 */
class SetOnboardingCompletedUseCase @Inject constructor(
    private val repository: UserRepository
) {
    suspend operator fun invoke(completed: Boolean) {
        repository.saveOnboardingCompleted(completed)
    }
}
