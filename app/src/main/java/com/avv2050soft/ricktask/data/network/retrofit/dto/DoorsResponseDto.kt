package com.avv2050soft.ricktask.data.network.retrofit.dto

import com.avv2050soft.ricktask.domain.models.doors.DoorItem
import com.google.gson.annotations.SerializedName

data class DoorsResponseDto(
    @SerializedName("data")
    val `data`: List<DoorItem>,
    @SerializedName("success")
    val success: Boolean
)
