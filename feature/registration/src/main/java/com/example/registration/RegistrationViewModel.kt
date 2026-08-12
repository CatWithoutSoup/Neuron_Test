package com.example.registration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.user.model.User
import com.example.user.usecase.SaveUserUseCase
import com.example.user.usecase.ValidateRegistrationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val saveUserUseCase: SaveUserUseCase,
    private val validateRegistrationUseCase: ValidateRegistrationUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(RegistrationUiState())
    val uiState: StateFlow<RegistrationUiState> = _uiState.asStateFlow()
    private val _events = Channel<RegistrationEvent>()
    val events = _events.receiveAsFlow()

    fun onParticipantNumberChanged(value: String) {
        val digits = value
            .filter(Char::isDigit)
            .take(16)

        val formatted = digits
            .chunked(4)
            .joinToString(" ")

        updateState(
            participantNumber = formatted,
        )
    }

    fun onCodeChanged(value: String) {
        updateState(
            code = value.filter(Char::isDigit),
        )
    }

    fun onFirstNameChanged(value: String) {
        updateState(
            firstName = value,
        )
    }

    fun onLastNameChanged(value: String) {
        updateState(
            lastName = value,
        )
    }

    fun onContinueClick() {
        val state = _uiState.value

        if (!state.isContinueEnabled) return

        viewModelScope.launch {
            saveUserUseCase(
                User(
                    participantNumber = state.participantNumber.filter(Char::isDigit),
                    code = state.code,
                    firstName = state.firstName,
                    lastName = state.lastName,
                )
            )
            _events.send(RegistrationEvent.Success)
        }
    }

    private fun updateState(
        participantNumber: String = _uiState.value.participantNumber,
        code: String = _uiState.value.code,
        firstName: String = _uiState.value.firstName,
        lastName: String = _uiState.value.lastName,
    ) {
        val isValid = validateRegistrationUseCase(
            participantNumber = participantNumber,
            code = code,
            firstName = firstName,
            lastName = lastName,
        )

        val participantDigits = participantNumber.filter(Char::isDigit)

        val participantNumberError =
            participantDigits.isNotEmpty() &&
                    participantDigits.length != 16

        _uiState.update {
            it.copy(
                participantNumber = participantNumber,
                code = code,
                firstName = firstName,
                lastName = lastName,
                isParticipantNumberError = participantNumberError,
                isContinueEnabled = isValid,
            )
        }
    }
}