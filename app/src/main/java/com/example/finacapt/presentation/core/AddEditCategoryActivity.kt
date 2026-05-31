package com.example.finacapt.presentation.core

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.finacapt.presentation.categories.CategoryViewModel
import com.example.finacapt.ui.theme.FinaCaptTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddEditCategoryActivity: ComponentActivity() {
    val viewModel by viewModels<CategoryViewModel>()
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContent {
            FinaCaptTheme {
                AddEditCategoryScreen(viewModel)
            }
        }
    }
}
