package com.avv2050soft.ricktask.data.network.retrofit.api

import com.avv2050soft.ricktask.data.network.retrofit.dto.CamerasResponseDto
import com.avv2050soft.ricktask.data.network.retrofit.dto.DoorsResponseDto
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface CprogroupApi {

    @GET("cameras/")
    suspend fun getCamerasResponse(): CamerasResponseDto

    @GET("doors/")
    suspend fun getDoorsResponse(): DoorsResponseDto


    companion object {
        private const val BASE_URL = "https://cars.cprogroup.ru/api/rubetek/"

        fun create(): CprogroupApi {
            val logger =
                HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CprogroupApi::class.java)
        }
    }
}