package com.example.user.usecase

class ValidateRegistrationUseCase {

    operator fun invoke(
        participantNumber: String,
        code: String,
        firstName: String,
        lastName: String,
    ): Boolean {
        val participantDigits = participantNumber.filter(Char::isDigit)

        return participantDigits.length == 16 &&
                code.isNotBlank() &&
                firstName.isNotBlank() &&
                lastName.isNotBlank()
    }
}