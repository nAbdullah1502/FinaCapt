package com.example.finacapt.presentation.expenses

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finacapt.data.entity.Expense
import com.example.finacapt.domain.usecase.expense.ExpenseUseCase
import com.example.finacapt.domain.usecase.expense.UiEvent
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class ExpenseViewModel @Inject constructor(
    private val useCase: ExpenseUseCase
) : ViewModel(){
    private val _state = MutableStateFlow(ExpenseState())
    val state = _state.asStateFlow()
    private val _uiEvent = MutableSharedFlow<UiEvent>()
    val uiEvent = _uiEvent.asSharedFlow()

    fun onEvent(event: ExpenseEvent ) {
        when(event){
            is ExpenseEvent.EraseExpense -> {
                viewModelScope.launch {
                    useCase.eraseExpense(event.eraseExpense.id)
                }
            }
            is ExpenseEvent.SetExpenseAmount -> _state.update { it.copy(amount = event.setAmount) }
            is ExpenseEvent.SetExpenseDescription ->
                _state.update { it.copy(description = event.setDescription) }
            is ExpenseEvent.SetExpenseTimeStamp ->
                _state.update{it.copy(timestamp = event.setTimeStamp)}
            is ExpenseEvent.SpecifyCategoryId ->
                _state.update{it.copy(categoryId = event.specifyCategoryId)}
            ExpenseEvent.AddExpense -> {
                val amount = _state.value.amount.toDoubleOrNull() ?: return
                val description = _state.value.description
                val timestamp = System.currentTimeMillis()
                val categoryId = _state.value.categoryId
                val expense = Expense(
                    amount=amount,
                    description = description,
                    timestamp = timestamp,
                    categoryId = categoryId
                )
                viewModelScope.launch {
                    useCase.addExpense(expense)
                    _uiEvent.emit(UiEvent.ExpenseSaved)
                    TODO("exceptions for invalid inserts from the user")
                }
            }
        }
    }
}