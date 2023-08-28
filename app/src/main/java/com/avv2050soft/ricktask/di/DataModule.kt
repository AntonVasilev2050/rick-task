package com.avv2050soft.ricktask.di

import android.app.Application
import android.content.Context
import com.avv2050soft.ricktask.data.local.realm.mappers.RealmMapper
import com.avv2050soft.ricktask.data.local.realm.repository.DatabaseRepositoryRealmImpl
import com.avv2050soft.ricktask.data.local.room.mappers.RoomMapper
import com.avv2050soft.ricktask.data.repository.CprogroupRepositoryImpl
import com.avv2050soft.ricktask.domain.repository.CprogroupRepository
import com.avv2050soft.ricktask.domain.repository.DatabaseRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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
    fun provideCprogroupMapper(): RoomMapper {
        return RoomMapper()
    }

    @Provides
    @Singleton
    fun provideRealmMapper(): RealmMapper{
        return RealmMapper()
    }

    @Provides
    @Singleton
    fun provideCprogroupRepository(): CprogroupRepository{
        return CprogroupRepositoryImpl(mapper = RoomMapper())
    }

//    Можно использовать Room Database
//    @Provides
//    @Singleton
//    fun provideDatabaseRepository(@ApplicationContext context: Context) : DatabaseRepository {
//        return DatabaseRepositoryImpl(context = context, mapper = CprogroupMapper())
//    }

    @Provides
    @Singleton
    fun provideDatabaseRealmRepository() : DatabaseRepository {
        return DatabaseRepositoryRealmImpl(mapper = RealmMapper())
    }
}