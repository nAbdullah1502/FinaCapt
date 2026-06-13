package com.example.finacapt.presentation.core.screen

import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.finacapt.presentation.categories.CategoryViewModel
import com.example.finacapt.presentation.categories.AddEditCategoryActivity
import com.example.finacapt.presentation.core.util.CategoryCardItem
import com.example.finacapt.presentation.core.util.CategoryColorProvider

@Composable
fun CategoryScreen(viewModel: CategoryViewModel){
    val context = LocalContext.current
    val categories = viewModel.getAllCategories().collectAsState(initial = emptyList())
    Scaffold(
        floatingActionButton = { FloatingActionButton(
            onClick = {
                val intent = Intent(context, AddEditCategoryActivity::class.java)
                context.startActivity(intent)
            }
        ){ Text("+") }}
    ){ paddingValues ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = paddingValues
        ) {
            items(categories.value) { category ->
                CategoryCardItem(
                    color = CategoryColorProvider.colors[category.colorId],
                    title = category.title,
                    spent = 0.0,
                    limit = category.limit,
                    modifier = Modifier.fillMaxSize(),
                    onClick = {},
                )
            }
        }
    }
}