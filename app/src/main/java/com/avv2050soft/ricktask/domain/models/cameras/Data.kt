package com.avv2050soft.ricktask.domain.models.cameras


import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class Data(
    @SerializedName("cameras")
    var cameras: List< CameraItem>,
    @SerializedName("room")
    val room: List<String>
)