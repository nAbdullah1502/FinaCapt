package com.example.finacapt.presentation.categories

import com.example.finacapt.data.entity.Category

sealed class CategoryEvent {
    data class DeleteCategory(val category: Category) : CategoryEvent()
    data object UpsertCategory : CategoryEvent()
    data class SetCategoryTitle (val setTitle: String): CategoryEvent()
    data class SetCategoryLimit (val setLimit: String): CategoryEvent()
}
