package com.avv2050soft.ricktask.domain.models.cameras


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("cameras")
    val cameraItems: List<CameraItem>,
    @SerializedName("room")
    val room: List<String>
)