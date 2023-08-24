package com.avv2050soft.ricktask.domain.models.doors

data class DoorsResponse(
    val `data`: List<DoorItem>,
    val success: Boolean
)