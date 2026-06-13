package com.example.finacapt.domain.usecase.category

import javax.inject.Inject

data class CategoryUseCases @Inject constructor(
    val getAllCategories: GetAllCategories,
    val upsertCategory: UpsertCategory,
    val deleteCategoryById: DeleteCategoryById,
)
