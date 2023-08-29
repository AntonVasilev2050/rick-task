package com.avv2050soft.ricktask.data.network.ktor.dto

import com.avv2050soft.ricktask.domain.models.cameras.Data
import kotlinx.serialization.Serializable

@Serializable
data class CamerasResponseKtorDto(
    val data: Data?,
    val success: Boolean
)
