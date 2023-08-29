package com.avv2050soft.ricktask.domain.models.doors

import kotlinx.serialization.Serializable

@Serializable
data class DoorsResponse(
    var `data`: List<DoorItem>,
    val success: Boolean
)