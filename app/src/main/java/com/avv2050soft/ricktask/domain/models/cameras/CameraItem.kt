package com.avv2050soft.ricktask.domain.models.cameras


import com.google.gson.annotations.SerializedName

data class CameraItem(
    @SerializedName("favorites")
    val favorites: Boolean,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("rec")
    val rec: Boolean,
    @SerializedName("room")
    val room: String,
    @SerializedName("snapshot")
    val snapshot: String
)