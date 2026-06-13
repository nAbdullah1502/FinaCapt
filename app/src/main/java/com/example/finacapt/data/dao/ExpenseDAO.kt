package com.example.finacapt.data.dao

import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.finacapt.data.entity.Expense
import kotlinx.coroutines.flow.Flow

interface ExpenseDAO {
    @Upsert
    suspend fun upsertExpense(expense: Expense)

    @Delete
    suspend fun deleteExpense(expense: Int)

    @Query("SELECT * FROM expense ORDER BY timestamp DESC")
    fun getAllExpenses(): Flow<List<Expense>>

    @Query("SELECT * FROM expense WHERE category_id = :categoryId ORDER BY timestamp DESC")
    fun getExpensesByCategory(categoryId: Int): Flow<List<Expense>>

    @Query("SELECT SUM(amount) FROM expense WHERE category_id = :categoryId")
    fun getTotalByCategory(categoryId: Int): Flow<Double?>

    @Query("SELECT SUM(amount) FROM expense")
    fun getTotalExpenses(): Flow<Double?>
}