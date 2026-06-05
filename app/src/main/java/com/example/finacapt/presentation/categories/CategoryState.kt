package com.example.finacapt.presentation.categories

import com.example.finacapt.data.entity.Category

data class CategoryState(
    val categoriesList : List<Category> = emptyList(),
    val stateTitle : String = "",
    val stateLimit : String = "",
    val stateColor : Int = 0
)
