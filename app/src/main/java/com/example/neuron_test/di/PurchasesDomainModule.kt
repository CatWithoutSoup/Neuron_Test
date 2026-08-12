package com.example.neuron_test.di

import com.example.purchases.repository.PurchasesRepository
import com.example.purchases.usecase.GetPurchasesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object PurchasesDomainModule {

    @Provides
    fun provideGetPurchasesUseCase(
        repository: PurchasesRepository,
    ): GetPurchasesUseCase {
        return GetPurchasesUseCase(repository)
    }
}