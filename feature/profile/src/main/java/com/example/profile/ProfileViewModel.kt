package com.example.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.user.usecase.ObserveUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

@HiltViewModel
class ProfileViewModel @Inject constructor(
    observeUserUseCase: ObserveUserUseCase,
) : ViewModel() {

    val uiState: StateFlow<ProfileUiState> =
        observeUserUseCase()
            .map { user ->
                ProfileUiState(
                    firstName = user?.firstName.orEmpty(),
                    lastName = user?.lastName.orEmpty(),
                )
            }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = ProfileUiState(),
            )
}