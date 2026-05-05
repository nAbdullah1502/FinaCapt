package com.example.finacapt.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.finacapt.data.dao.CategoryDAO
import com.example.finacapt.data.dao.ExpenseDAO
import com.example.finacapt.data.dao.IncomeDAO
import com.example.finacapt.data.entity.Category
import com.example.finacapt.data.entity.Expense
import com.example.finacapt.data.entity.Income


@Database(
    entities = [
        Category::class,
        Income::class,
        Expense::class
    ],
    version = 1,
    exportSchema = false,
)
abstract class Database: RoomDatabase() {
    abstract fun categoryDao(): CategoryDAO
    abstract fun incomeDao(): IncomeDAO
    abstract fun expenseDao(): ExpenseDAO
}
