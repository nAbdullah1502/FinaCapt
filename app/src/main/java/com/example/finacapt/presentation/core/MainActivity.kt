package com.example.finacapt.presentation.core

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.finacapt.presentation.categories.CategoryViewModel
import com.example.finacapt.presentation.core.util.AppNavGraph
import com.example.finacapt.presentation.core.util.BottomBar
import com.example.finacapt.ui.theme.FinaCaptTheme
import kotlin.getValue

class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<CategoryViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            FinaCaptTheme {
                Scaffold(
                    bottomBar = {
                        BottomBar(navController = navController)
                    }
                ) { padding ->
                    Box(modifier = Modifier.padding(padding)) {
                        AppNavGraph(navController, viewModel)
                    }
                }
            }
        }
    }
}