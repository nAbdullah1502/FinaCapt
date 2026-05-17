package com.example.finacapt.domain.usecase

import javax.inject.Inject

data class CategoryUseCases @Inject constructor(
    val getAllCategories: GetAllCategories,
    val upsertCategory: UpsertCategory,
    val deleteCategoryByTitle: DeleteCategoryByTitle,
)
