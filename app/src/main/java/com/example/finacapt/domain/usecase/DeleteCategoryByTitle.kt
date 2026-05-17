package com.example.finacapt.domain.usecase

import com.example.finacapt.domain.repository.Repository
import com.example.finacapt.domain.util.exception.InvalidCategoryException
import javax.inject.Inject

class DeleteCategoryByTitle @Inject constructor(
    private val repository: Repository
){
    suspend operator fun invoke(categoryTitle:String) {
        if (categoryTitle.isBlank())
            throw InvalidCategoryException("The title of the category can't be empty.")
        else repository.deleteCategoryByTitle(categoryTitle)
    }
}