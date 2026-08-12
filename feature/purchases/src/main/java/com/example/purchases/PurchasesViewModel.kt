package com.example.purchases

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.purchases.usecase.GetPurchasesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import java.time.format.DateTimeFormatter
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class PurchasesViewModel @Inject constructor(
    private val getPurchasesUseCase: GetPurchasesUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(PurchasesUiState())
    val uiState: StateFlow<PurchasesUiState> = _uiState.asStateFlow()

    init {
        loadPurchases()
    }

    private fun loadPurchases() {
        viewModelScope.launch {
            val groups = getPurchasesUseCase()
                .map { group ->
                    PurchaseGroupUi(
                        date = group.date.format(DATE_FORMATTER),
                        names = group.names,
                    )
                }

            _uiState.update {
                it.copy(
                    isLoading = false,
                    groups = groups,
                )
            }
        }
    }

    private companion object {
        val DATE_FORMATTER: DateTimeFormatter =
            DateTimeFormatter.ofPattern("dd.MM.yyyy")
    }
}