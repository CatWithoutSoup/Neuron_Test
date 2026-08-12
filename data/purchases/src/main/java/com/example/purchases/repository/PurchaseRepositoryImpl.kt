package com.example.purchases.repository

import com.example.purchases.model.Purchase
import java.time.Instant
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PurchasesRepositoryImpl @Inject constructor() : PurchasesRepository {

    override suspend fun getPurchases(): List<Purchase> {
        return listOf(
            Purchase(
                date = Instant.parse("2022-09-10T21:55:33Z"),
                names = listOf("123", "321"),
            ),
            Purchase(
                date = Instant.parse("2022-09-10T21:50:33Z"),
                names = listOf("1234", "4321"),
            ),
            Purchase(
                date = Instant.parse("2022-09-08T01:55:33Z"),
                names = listOf("12345", "54321"),
            ),
            Purchase(
                date = Instant.parse("2022-09-07T21:55:33Z"),
                names = listOf("123456", "654321"),
            ),
            Purchase(
                date = Instant.parse("2022-09-07T11:55:33Z"),
                names = listOf("1234567", "7654321"),
            ),
        )
    }
}