package com.avv2050soft.ricktask.di

import android.app.Application
import android.content.Context
import com.avv2050soft.ricktask.data.mappers.CprogroupMapper
import com.avv2050soft.ricktask.data.repository.CprogroupRepositoryImpl
import com.avv2050soft.ricktask.data.repository.DatabaseRepositoryImpl
import com.avv2050soft.ricktask.domain.repository.CprogroupRepository
import com.avv2050soft.ricktask.domain.repository.DatabaseRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }

    @Provides
    @Singleton
    fun provideCprogroupMapper(): CprogroupMapper{
        return CprogroupMapper()
    }

    @Provides
    @Singleton
    fun provideCprogroupRepository(): CprogroupRepository{
        return CprogroupRepositoryImpl(mapper = CprogroupMapper())
    }

    @Provides
    @Singleton
    fun provideDatabaseRepository(@ApplicationContext context: Context) : DatabaseRepository {
        return DatabaseRepositoryImpl(context = context, mapper = CprogroupMapper())
    }
}