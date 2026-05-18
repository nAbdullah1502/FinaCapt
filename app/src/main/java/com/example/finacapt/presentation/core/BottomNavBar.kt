package com.example.finacapt.presentation.core

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChecklistRtl
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.StackedLineChart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.finacapt.presentation.core.screen.BudgetOverviewScreen
import com.example.finacapt.presentation.core.screen.CategoryAnalysisScreen
import com.example.finacapt.presentation.core.screen.CategoryScreen
import com.example.finacapt.presentation.core.screen.SettingsScreen


sealed class Screen(val route: String, val label: String){
    object BudgetOverviewScreen : Screen("BudgetOverview", "BudgetOverview")
    object Category: Screen("Category", "Category list and add")
    object Settings: Screen("Settings", "Settings")
    object Stats: Screen("Stats", "Statistics")
}

val items = listOf(
    Screen.BudgetOverviewScreen,
    Screen.Category,
    Screen.Settings,
    Screen.Stats
)

@Composable
fun BottomBar(navController: NavHostController){
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    NavigationBar {
        items.forEach { screen ->
            val isSelected = currentRoute == screen.route
            NavigationBarItem(
                selected=isSelected,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(Screen.Category.route)
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        imageVector = when(screen){
                            Screen.Category -> Icons.Default.Home
                            Screen.BudgetOverviewScreen -> Icons.Default.ChecklistRtl
                            Screen.Stats -> Icons.Default.StackedLineChart
                            Screen.Settings -> Icons.Default.Settings
                        },
                        contentDescription = screen.route
                    )
                },
                label = { Text(screen.route) },
            )
        }
    }
}

@Composable
fun AppNavGraph(
    navController: NavHostController,
    viewModel: ViewModel
){
    NavHost(navController = navController, startDestination = Screen.BudgetOverviewScreen.route) {
        composable(Screen.BudgetOverviewScreen.route){BudgetOverviewScreen(viewModel)}
        composable(Screen.Category.route){CategoryScreen(viewModel)}
        composable(Screen.Stats.route) { CategoryAnalysisScreen(viewModel) }
        composable(Screen.Settings.route) {SettingsScreen(viewModel) }
    }
}