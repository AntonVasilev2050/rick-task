package com.avv2050soft.ricktask.data.network.retrofit.dto

import com.avv2050soft.ricktask.domain.models.cameras.Data
import com.google.gson.annotations.SerializedName

data class CamerasResponseDto(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("success")
    val success: Boolean
)
