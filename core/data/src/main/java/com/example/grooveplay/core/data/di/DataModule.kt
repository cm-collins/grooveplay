package com.example.grooveplay.core.data.di

import android.content.Context
import com.example.grooveplay.core.data.repository.UserPreferencesRepository
import com.example.grooveplay.core.data.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideUserRepository(
        @ApplicationContext context: Context
    ): UserRepository = UserPreferencesRepository(context)
}
