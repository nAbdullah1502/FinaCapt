package com.example.finacapt.data.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import com.example.finacapt.data.entity.Category
import com.example.finacapt.data.CategoryWithExpense
import kotlinx.coroutines.flow.Flow


@Dao
interface CategoryDAO {
    @Upsert
    suspend fun upsertCategory(category: Category)

    @Query("SELECT * FROM category")
    fun getAllCategories(): Flow<List<Category>>

    @Query("SELECT * FROM category WHERE id = :id")
    suspend fun getCategoryById(id: Int): Category?

    @Query("DELETE FROM category WHERE title = :title")
    suspend fun deleteByTitle(title:String)

    @Transaction
    @Query("SELECT * FROM category")
    fun getCategoriesWithExpenses(): Flow<List<CategoryWithExpense>>
}