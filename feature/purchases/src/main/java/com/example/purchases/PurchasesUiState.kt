package com.example.purchases

data class PurchasesUiState(
    val isLoading: Boolean = true,
    val groups: List<PurchaseGroupUi> = emptyList(),
)

data class PurchaseGroupUi(
    val date: String,
    val names: List<String>,
)