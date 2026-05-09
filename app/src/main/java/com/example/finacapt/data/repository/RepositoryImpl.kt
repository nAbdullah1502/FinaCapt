package com.example.finacapt.data.repository

import com.example.finacapt.data.dao.CategoryDAO
import com.example.finacapt.data.dao.ExpenseDAO
import com.example.finacapt.data.dao.IncomeDAO
import com.example.finacapt.data.entity.Category
import com.example.finacapt.data.entity.Expense
import com.example.finacapt.data.entity.Income
import com.example.finacapt.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val categoryDao: CategoryDAO,
    private val incomeDao: IncomeDAO,
    private val expenseDao: ExpenseDAO
): Repository {
    override suspend fun upsertCategory(category: Category) {
        categoryDao.upsertCategory(category=category)
    }

    override fun getAllCategories(): Flow<List<Category>> {
        return categoryDao.getAllCategories()
    }

    override suspend fun getCategoryById(id: Int): Category? {
        return categoryDao.getCategoryById(id=id)
    }

    override suspend fun deleteByTitle(title: String) {
        categoryDao.deleteByTitle(title=title)
    }

    override suspend fun upsertExpense(expense: Expense) {
        expenseDao.upsertExpense(expense = expense)
    }

    override suspend fun deleteExpense(expense: Expense) {
        expenseDao.deleteExpense(expense=expense)
    }

    override fun getAllExpenses(): Flow<List<Expense>> {
        return expenseDao.getAllExpenses()
    }

    override fun getExpensesByCategory(categoryId: Int): Flow<List<Expense>> {
        return getExpensesByCategory(categoryId=categoryId)
    }

    override fun getTotalByCategory(categoryId: Int): Flow<Double?> {
        return expenseDao.getTotalByCategory(categoryId=categoryId)
    }

    override fun getTotalExpenses(): Flow<Double?> {
        return getTotalExpenses()
    }

    override suspend fun insertIncome(income: Income) {
        incomeDao.upsertIncome(income=income)
    }

    override suspend fun deleteIncome(income: Income) {
        incomeDao.deleteIncome(income=income)
    }

    override fun getAllIncome(): Flow<List<Income>> {
        return incomeDao.getAllIncome()
    }

    override fun getTotalIncome(): Flow<Double?> {
        return incomeDao.getTotalIncome()
    }
}