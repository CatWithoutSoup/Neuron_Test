package com.example.purchases

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun PurchasesRoute(
    onBack: () -> Unit,
    viewModel: PurchasesViewModel = hiltViewModel(),
) {
    val state = viewModel.uiState
        .collectAsStateWithLifecycle()
        .value

    PurchasesScreen(
        state = state,
        onBack = onBack,
    )
}