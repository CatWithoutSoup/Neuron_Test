package com.example.purchases.model

import java.time.Instant

data class Purchase(
    val date: Instant,
    val names: List<String>,
)