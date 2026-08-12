package com.example.purchases.repository

import com.example.purchases.model.Purchase

interface PurchasesRepository {
    suspend fun getPurchases(): List<Purchase>
}