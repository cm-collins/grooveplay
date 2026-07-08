package com.example.grooveplay.core.domain.usecase

import com.example.grooveplay.core.data.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * UseCase to retrieve the current onboarding completion status.
 */
class GetOnboardingStatusUseCase @Inject constructor(
    private val repository: UserRepository
) {
    operator fun invoke(): Flow<Boolean> = repository.isOnboardingCompleted
}
