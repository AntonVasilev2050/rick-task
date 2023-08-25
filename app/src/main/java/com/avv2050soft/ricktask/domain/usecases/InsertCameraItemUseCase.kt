package com.avv2050soft.ricktask.domain.usecases

import com.avv2050soft.ricktask.domain.models.cameras.CameraItem
import com.avv2050soft.ricktask.domain.repository.DatabaseRepository
import javax.inject.Inject

class InsertCameraItemUseCase @Inject constructor(
    private val repository: DatabaseRepository
){
  suspend fun insertInDb(cameraItem: CameraItem) {
      repository.insertCameraItem(cameraItem)
  }
}