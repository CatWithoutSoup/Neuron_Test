package com.example.user.di

import com.example.user.repository.UserRepositoryImpl
import com.example.user.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class UserDataModule {

    @Binds
    @Singleton
    abstract fun bindUserRepository(
        implementation: UserRepositoryImpl,
    ): UserRepository
}