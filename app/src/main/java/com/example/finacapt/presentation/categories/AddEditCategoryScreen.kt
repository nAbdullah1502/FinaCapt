package com.example.finacapt.presentation.categories

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.navigation.NavController

@Composable
fun AddEditCategoryScreen(
    viewModel: CategoryViewModel,
    navController: NavController
){
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
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
                    .padding(16.dp)
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
                TextField(value = state.value.stateLimit, onValueChange={})
            }
        }
    )
}
