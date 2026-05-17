package com.example.finacapt.domain.usecase

import com.example.finacapt.domain.repository.Repository
import com.example.finacapt.domain.util.exception.InvalidCategoryException
import javax.inject.Inject

class DeleteCategoryById @Inject constructor(
    private val repository: Repository
){
    suspend operator fun invoke(id:Int) {
        repository.deleteCategoryById(id)
    }
}