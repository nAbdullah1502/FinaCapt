package com.example.finacapt.presentation.categories

sealed class UIEvent {
    data object NavigateBack : UIEvent()
    data class ShowSnackBar (val message: String): UIEvent()
}