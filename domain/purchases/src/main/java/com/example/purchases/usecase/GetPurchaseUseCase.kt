package com.example.purchases.usecase

import com.example.purchases.model.PurchaseGroup
import com.example.purchases.repository.PurchasesRepository
import java.time.ZoneOffset

class GetPurchasesUseCase(
    private val repository: PurchasesRepository,
) {

    suspend operator fun invoke(): List<PurchaseGroup> {
        return repository
            .getPurchases()
            .groupBy { purchase ->
                purchase.date
                    .atZone(ZoneOffset.UTC)
                    .toLocalDate()
            }
            .map { (date, purchases) ->
                PurchaseGroup(
                    date = date,
                    names = purchases.flatMap { it.names },
                )
            }
            .sortedByDescending { it.date }
    }
}