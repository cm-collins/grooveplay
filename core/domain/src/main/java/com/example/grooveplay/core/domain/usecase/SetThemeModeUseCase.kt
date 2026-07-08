package com.example.grooveplay.core.domain.usecase

import com.example.grooveplay.core.data.repository.UserRepository
import com.example.grooveplay.core.model.ThemeMode
import javax.inject.Inject

/**
 * UseCase to persist the user's theme mode selection.
 */
class SetThemeModeUseCase @Inject constructor(
    private val repository: UserRepository
) {
    suspend operator fun invoke(mode: ThemeMode) {
        repository.setThemeMode(mode)
    }
}
