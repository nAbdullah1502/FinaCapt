package com.example.finacapt.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.finacapt.data.entity.Income
import kotlinx.coroutines.flow.Flow

@Dao
interface IncomeDAO {
    @Upsert
    suspend fun upsertIncome(income: Income)

    @Delete
    suspend fun deleteIncome(income: Income)

    @Query("SELECT * FROM income ORDER BY timestamp DESC")
    fun getAllIncome(): Flow<List<Income>>

    @Query("SELECT SUM(amount) FROM income")
    fun getTotalIncome(): Flow<Double?>
}