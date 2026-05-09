package com.example.finacapt.domain.usecase

import com.example.finacapt.data.entity.Category
import com.example.finacapt.domain.repository.Repository
import com.example.finacapt.domain.util.exception.InvalidCategoryException
import javax.inject.Inject


class UpsertCategory @Inject constructor(
    private val repository: Repository
){
    suspend operator fun invoke(category: Category) {
        if (category.title.isBlank()) {
            throw InvalidCategoryException("The title of the category can't be empty.")
        }
        if (category.limit < 0){
            throw InvalidCategoryException("The limit of the category can't be negative.")
        }
        repository.upsertCategory(category)
    }
}