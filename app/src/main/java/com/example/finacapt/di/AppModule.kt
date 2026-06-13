package com.example.finacapt.di

import android.app.Application
import androidx.room.Room
import com.example.finacapt.data.Database
import com.example.finacapt.data.repository.RepositoryImpl
import com.example.finacapt.domain.repository.Repository
import com.example.finacapt.domain.usecase.category.CategoryUseCases
import com.example.finacapt.domain.usecase.category.DeleteCategoryById
import com.example.finacapt.domain.usecase.category.GetAllCategories
import com.example.finacapt.domain.usecase.category.UpsertCategory
import com.example.finacapt.domain.usecase.expense.AddExpense
import com.example.finacapt.domain.usecase.expense.EraseExpenseById
import com.example.finacapt.domain.usecase.expense.ExpenseUseCase
import com.example.finacapt.domain.usecase.expense.GetAllExpenses
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(app: Application): Database {
        return Room.databaseBuilder(
            app,
            Database::class.java,
            "finacapt.db").build()
    }

    @Provides
    @Singleton
    fun provideRepository(db: Database): Repository {
        return RepositoryImpl(
            categoryDao = db.categoryDao(),
            incomeDao =  db.incomeDao(),
            expenseDao = db.expenseDao())
    }

    @Provides
    @Singleton
    fun provideCategoryUseCases(repository: Repository): CategoryUseCases{
        return CategoryUseCases(
            upsertCategory = UpsertCategory(repository),
            getAllCategories = GetAllCategories(repository),
            deleteCategoryById = DeleteCategoryById(repository)
        )
    }

    @Provides
    @Singleton
    fun provideExpenseUseCases(repository: Repository): ExpenseUseCase{
        return ExpenseUseCase(
            addExpense = AddExpense(repository),
            getAllExpenses = GetAllExpenses(repository),
            eraseExpense = EraseExpenseById(repository),
        )
    }
}