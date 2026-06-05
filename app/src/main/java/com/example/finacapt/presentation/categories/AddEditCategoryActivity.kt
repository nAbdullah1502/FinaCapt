package com.example.finacapt.presentation.categories

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.rememberNavController
import com.example.finacapt.ui.theme.FinaCaptTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddEditCategoryActivity: ComponentActivity() {
    val viewModel by viewModels<CategoryViewModel>()
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            LaunchedEffect(Unit) {
                viewModel.uiEvent.collect { event ->
                    when(event) {
                        UIEvent.NavigateBack -> {
                            navController.popBackStack()
                        }

                        is UIEvent.ShowSnackBar -> {
                            // show ShowSnackBar
                        }
                    }
                }
            }
            FinaCaptTheme {
                AddEditCategoryScreen(viewModel, navController)
            }
        }
    }
}
