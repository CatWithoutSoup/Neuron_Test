package com.example.profile

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun ProfileRoute(
    onBack: () -> Unit,
    onRegistrationClick: () -> Unit,
    onPurchasesClick: () -> Unit = {},
    viewModel: ProfileViewModel = hiltViewModel(),
) {
    val state = viewModel.uiState
        .collectAsStateWithLifecycle()
        .value

    ProfileScreen(
        state = state,
        onBack = onBack,
        onRegistrationClick = onRegistrationClick,
        onPurchasesClick = onPurchasesClick,
    )
}