package com.avv2050soft.ricktask.di

import android.app.Application
import android.content.Context
import com.avv2050soft.ricktask.data.local.realm.mappers.RealmMapper
import com.avv2050soft.ricktask.data.local.realm.repository.DatabaseRepositoryRealmImpl
import com.avv2050soft.ricktask.data.local.room.mappers.RoomMapper
import com.avv2050soft.ricktask.data.local.room.repository.DatabaseRepositoryRoomImpl
import com.avv2050soft.ricktask.data.network.ktor.mappers.KtorMapper
import com.avv2050soft.ricktask.data.network.ktor.repository.CprogroupRepositoryKtorImp
import com.avv2050soft.ricktask.data.network.retrofit.mappers.RetrofitMapper
import com.avv2050soft.ricktask.data.network.retrofit.repository.CprogroupRepositoryRetrofitImpl
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
    fun provideCprogroupMapper(): RoomMapper {
        return RoomMapper()
    }

    @Provides
    @Singleton
    fun provideRealmMapper(): RealmMapper {
        return RealmMapper()
    }

    @Provides
    @Singleton
    fun provideKtorMapper(): KtorMapper {
        return KtorMapper()
    }

    @Provides
    @Singleton
    fun provideRetrofitMapper(): RetrofitMapper {
        return RetrofitMapper()
    }

//    Можно использовать Retrofit или Ktor
//    @Provides
//    @Singleton
//    fun provideCprogroupRepository(): CprogroupRepository{
//        return CprogroupRepositoryRetrofitImpl(mapper = RetrofitMapper())
//    }

    @Provides
    @Singleton
    fun provideCprogroupRepository(): CprogroupRepository {
        return CprogroupRepositoryKtorImp(mapper = KtorMapper())
    }

//    Можно использовать Room Database или Realm
//    @Provides
//    @Singleton
//    fun provideDatabaseRepository(@ApplicationContext context: Context) : DatabaseRepository {
//        return DatabaseRepositoryRoomImpl(context = context, mapper = RoomMapper())
//    }

    @Provides
    @Singleton
    fun provideDatabaseRealmRepository(): DatabaseRepository {
        return DatabaseRepositoryRealmImpl(mapper = RealmMapper())
    }
}