package com.avv2050soft.ricktask.domain.models.doors


import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class DoorItem(
    @SerializedName("favorites")
    val favorites: Boolean,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("room")
    var room: String?,
    @SerializedName("snapshot")
    var snapshot: String?
)