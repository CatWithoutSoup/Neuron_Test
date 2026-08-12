package com.example.registration

sealed interface RegistrationEvent {
    data object Success: RegistrationEvent
}