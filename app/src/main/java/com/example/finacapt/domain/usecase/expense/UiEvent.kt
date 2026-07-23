package com.example.finacapt.domain.usecase.expense

sealed interface UiEvent {
    data object ExpenseSaved: UiEvent
    data class ShowError(val message: String): UiEvent
}