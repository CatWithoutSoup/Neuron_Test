package com.example.profile

data class ProfileUiState(
    val firstName: String = "",
    val lastName: String = "",
    val isBiometricsEnabled: Boolean = true,
) {
    val hasUser: Boolean
        get() = firstName.isNotBlank() && lastName.isNotBlank()
}