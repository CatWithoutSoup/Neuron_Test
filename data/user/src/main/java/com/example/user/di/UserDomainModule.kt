package com.example.user.di

import com.example.user.repository.UserRepository
import com.example.user.usecase.ObserveUserUseCase
import com.example.user.usecase.SaveUserUseCase
import com.example.user.usecase.ValidateRegistrationUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UserDomainModule {

    @Provides
    fun provideObserveUserUseCase(
        repository: UserRepository,
    ): ObserveUserUseCase {
        return ObserveUserUseCase(repository)
    }

    @Provides
    fun provideSaveUserUseCase(
        repository: UserRepository,
    ): SaveUserUseCase {
        return SaveUserUseCase(repository)
    }

    @Provides
    fun provideValidateRegistrationUseCase(): ValidateRegistrationUseCase {
        return ValidateRegistrationUseCase()
    }
}