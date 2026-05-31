package com.example.finacapt.presentation.core

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Save
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.finacapt.presentation.categories.CategoryEvent
import com.example.finacapt.presentation.categories.CategoryViewModel

@Composable
fun AddEditCategoryScreen(viewModel: CategoryViewModel){
    val state = viewModel.state.collectAsState()
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {viewModel.onEvent(CategoryEvent.UpsertCategory)}
            ) {
                Icon(imageVector = Icons.Default.Save, contentDescription = "save")
            }
        },
        content = { paddingValues->
            Box(modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
            ){
                TextField(
                    value = state.value.stateTitle,
                    onValueChange = {viewModel.onEvent(CategoryEvent.SetCategoryTitle(it))},
                    label = { Text("Category title") },
                    placeholder = { Text("some category ...") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.width(8.dp))

            }
        }
    )


}
