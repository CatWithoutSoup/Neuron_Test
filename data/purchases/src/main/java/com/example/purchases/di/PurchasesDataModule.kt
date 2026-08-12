package com.example.purchases.di

import com.example.purchases.repository.PurchasesRepositoryImpl
import com.example.purchases.repository.PurchasesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class PurchasesDataModule {

    @Binds
    @Singleton
    abstract fun bindPurchasesRepository(
        implementation: PurchasesRepositoryImpl,
    ): PurchasesRepository
}