package com.example.finacapt.presentation.categories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finacapt.data.entity.Category
import com.example.finacapt.domain.usecase.CategoryUseCases
import com.example.finacapt.domain.util.wrapper.AddCategoryUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
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

    private val _categoryTitle = MutableStateFlow(AddCategoryUiState())
    val categoryTitle = _categoryTitle.asStateFlow()
    fun getAllCategories() = useCase.getAllCategories()

    fun onEvent(event: CategoryEvent){
        when(event){
            is CategoryEvent.SetCategoryTitle -> _state.update {it.copy(stateTitle=event.setTitle)}
            is CategoryEvent.SetCategoryLimit -> _state.update {it.copy(stateLimit=event.setLimit)}
            is CategoryEvent.DeleteCategory -> { viewModelScope.launch {
                if(event.category.id != null) useCase.deleteCategoryById(event.category.id) }
            }
            is CategoryEvent.UpsertCategory -> {
                val title = state.value.stateTitle
                val limit = state.value.stateLimit
                if (title.isBlank()) { return }
                val category = Category(title = title, limit = limit, icon="")
                viewModelScope.launch {
                    val useCase = null
                    useCase?.invoke(category)
                }
            }
        }
    }
}