package com.example.finacapt.di

import android.app.Application
import androidx.room.Room
import com.example.finacapt.data.Database
import com.example.finacapt.data.repository.RepositoryImpl
import com.example.finacapt.domain.repository.Repository
import com.example.finacapt.domain.usecase.CategoryUseCases
import com.example.finacapt.domain.usecase.GetAllCategories
import com.example.finacapt.domain.usecase.UpsertCategory
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
            getAllCategories = GetAllCategories(repository)
        )
    }
}