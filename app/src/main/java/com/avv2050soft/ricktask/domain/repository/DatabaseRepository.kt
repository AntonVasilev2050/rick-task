package com.avv2050soft.ricktask.domain.repository

import com.avv2050soft.ricktask.domain.models.cameras.CameraItem
import com.avv2050soft.ricktask.domain.models.doors.DoorItem

interface DatabaseRepository {
    suspend fun insertCameraItem(cameraItem: CameraItem)
    suspend fun insertDoorItem(doorItem: DoorItem)
    suspend fun getAllCameraItems(): List<CameraItem>
    suspend fun getAllDoorItems(): List<DoorItem>
}