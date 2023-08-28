package com.avv2050soft.ricktask.domain.usecases

import com.avv2050soft.ricktask.domain.models.cameras.CameraItem
import com.avv2050soft.ricktask.domain.repository.DatabaseRepository
import javax.inject.Inject

class GetAllCameraItemsUseCase @Inject constructor(
    private val repository: DatabaseRepository
) {
    suspend fun getAllCameraItems(): List<CameraItem>{
        val cameraItems = repository.getAllCameraItems()
        return cameraItems
    }
}