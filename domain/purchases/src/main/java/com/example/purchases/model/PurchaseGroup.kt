package com.example.purchases.model

import java.time.LocalDate

data class PurchaseGroup(
    val date: LocalDate,
    val names: List<String>,
)