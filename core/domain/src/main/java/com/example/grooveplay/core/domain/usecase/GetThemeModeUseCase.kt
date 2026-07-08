package com.example.grooveplay.core.domain.usecase

import com.example.grooveplay.core.data.repository.UserRepository
import com.example.grooveplay.core.model.ThemeMode
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * UseCase to retrieve the current theme mode selection.
 */
class GetThemeModeUseCase @Inject constructor(
    private val repository: UserRepository
) {
    operator fun invoke(): Flow<ThemeMode> = repository.themeMode
}
