package com.avv2050soft.ricktask.data.network.ktor.dto

import com.avv2050soft.ricktask.domain.models.doors.DoorItem
import kotlinx.serialization.Serializable

@Serializable
data class DoorsResponseKtorDto(
    val `data`: List<DoorItem>?,
    val success: Boolean
)
