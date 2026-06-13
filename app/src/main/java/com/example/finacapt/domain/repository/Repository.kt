package com.example.finacapt.domain.repository

import com.example.finacapt.data.entity.Category
import com.example.finacapt.data.entity.Expense
import com.example.finacapt.data.entity.Income
import kotlinx.coroutines.flow.Flow

interface Repository{
    suspend fun upsertCategory(category: Category)
    fun getAllCategories(): Flow<List<Category>>
    suspend fun getCategoryById(id: Int): Category?
    suspend fun deleteCategoryById(id:Int)

    suspend fun upsertExpense(expense: Expense)
    suspend fun deleteExpense(expense: Int)
    fun getAllExpenses(): Flow<List<Expense>>
    fun getExpensesByCategory(categoryId: Int): Flow<List<Expense>>
    fun getTotalByCategory(categoryId: Int): Flow<Double?>
    fun getTotalExpenses(): Flow<Double?>

    suspend fun insertIncome(income: Income)
    suspend fun deleteIncome(income: Income)
    fun getAllIncome(): Flow<List<Income>>
    fun getTotalIncome(): Flow<Double?>
}

