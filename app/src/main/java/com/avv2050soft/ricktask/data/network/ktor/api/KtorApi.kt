package com.avv2050soft.ricktask.data.network.ktor.api

import com.avv2050soft.ricktask.data.network.ktor.dto.CamerasResponseKtorDto
import com.avv2050soft.ricktask.data.network.ktor.dto.DoorsResponseKtorDto
import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logging
import io.ktor.client.request.get

interface KtorApi {

    suspend fun getCamerasResponse(): CamerasResponseKtorDto
    suspend fun getDoorsResponse(): DoorsResponseKtorDto

    companion object {
        private const val BASE_URL = "https://cars.cprogroup.ru/api/rubetek/"
        const val CAMERAS = "$BASE_URL/cameras/"
        const val DOORS = "$BASE_URL/doors/"

        fun create(): KtorApi {
            val client = HttpClient {
                install(JsonFeature){
//                    serializer = KotlinxSerializer()
                    serializer = KotlinxSerializer(json)
                }
                install(Logging){
                    level = LogLevel.ALL
                }
            }

            return object : KtorApi {
                override suspend fun getCamerasResponse(): CamerasResponseKtorDto {
                    return client.get(CAMERAS)
                }

                override suspend fun getDoorsResponse(): DoorsResponseKtorDto {
                    return client.get(DOORS)
                }

            }
        }

        private val json = kotlinx.serialization.json.Json {
            ignoreUnknownKeys = true
            isLenient = true
            encodeDefaults = false
        }
    }
}