package com.example.registration

data class RegistrationUiState(
    val participantNumber: String = "",
    val code: String = "",
    val firstName: String = "",
    val lastName: String = "",
    val isContinueEnabled: Boolean = false,
    val isParticipantNumberError: Boolean = false,
)
