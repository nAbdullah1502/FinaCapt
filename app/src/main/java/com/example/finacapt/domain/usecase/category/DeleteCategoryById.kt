package com.example.finacapt.domain.usecase.category

import com.example.finacapt.domain.repository.Repository
import javax.inject.Inject

class DeleteCategoryById @Inject constructor(
    private val repository: Repository
){
    suspend operator fun invoke(id:Int) {
        repository.deleteCategoryById(id)
    }
}