package com.example.registration

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun RegistrationRoute(
    onBack: () -> Unit,
    viewModel: RegistrationViewModel = hiltViewModel(),
) {
    val state = viewModel.uiState.collectAsStateWithLifecycle().value

    LaunchedEffect(Unit) {
        viewModel.events.collect { event ->
            when (event) {
                RegistrationEvent.Success -> onBack()
            }
        }
    }

    RegistrationScreen(
        state = state,
        onParticipantNumberChanged = viewModel::onParticipantNumberChanged,
        onCodeChanged = viewModel::onCodeChanged,
        onFirstNameChanged = viewModel::onFirstNameChanged,
        onLastNameChanged = viewModel::onLastNameChanged,
        onContinueClick = viewModel::onContinueClick,
        onBack = onBack,
    )
}