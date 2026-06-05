package com.example.finacapt.presentation.core.screen

import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.finacapt.presentation.categories.CategoryViewModel
import com.example.finacapt.presentation.categories.AddEditCategoryActivity

@Composable
fun CategoryScreen(viewModel: CategoryViewModel){
    val context = LocalContext.current
    Scaffold(
        floatingActionButton = { FloatingActionButton(
            onClick = {
                val intent = Intent(context, AddEditCategoryActivity::class.java)
                context.startActivity(intent)
            }
        ){ Text("+") }}
    ){ paddingValues ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = paddingValues
        ) {

        }
    }
}