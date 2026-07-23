package com.example.finacapt.presentation.categories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finacapt.data.entity.Category
import com.example.finacapt.domain.usecase.category.CategoryUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    val useCase: CategoryUseCases
) : ViewModel() {

    private val _state = MutableStateFlow(CategoryState())
    val state = _state.asStateFlow()
    private val _uiEvent = MutableSharedFlow<UIEvent>()
    val uiEvent = _uiEvent.asSharedFlow()

    fun getAllCategories() = useCase.getAllCategories()

    fun onEvent(event: CategoryEvent){
        when(event){
            is CategoryEvent.SetCategoryTitle -> _state.update {it.copy(stateTitle=event.setTitle)}
            is CategoryEvent.SetCategoryLimit -> _state.update {it.copy(stateLimit=event.setLimit)}
            is CategoryEvent.SetCategoryColor -> _state.update {it.copy(stateColor=event.setColor)}
            is CategoryEvent.DeleteCategory -> {
                viewModelScope.launch {
                    if(event.category.id != null) useCase.deleteCategoryById(event.category.id)
                }
            }
            is CategoryEvent.UpsertCategory -> {
                val title = _state.value.stateTitle
                val limit = _state.value.stateLimit.toDouble()
                if (title.isBlank()) { return }
                val category = Category(title = title, limit = limit, colorId = 0)
                viewModelScope.launch {
                    useCase.upsertCategory(category)
                    _uiEvent.emit(UIEvent.NavigateBack)
                }
            }
        }
    }
}