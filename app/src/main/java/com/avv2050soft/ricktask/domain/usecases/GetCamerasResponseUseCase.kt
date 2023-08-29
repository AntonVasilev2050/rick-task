package com.avv2050soft.ricktask.domain.usecases

import com.avv2050soft.ricktask.domain.models.cameras.CameraItem
import com.avv2050soft.ricktask.domain.models.cameras.CamerasResponse
import com.avv2050soft.ricktask.domain.repository.CprogroupRepository
import javax.inject.Inject

class GetCamerasResponseUseCase @Inject constructor(
    private val repository: CprogroupRepository
) {
    suspend fun getCamerasResponse(): CamerasResponse {
        val checkedCameraItemsList = mutableListOf<CameraItem>()
        val camerasResponse = repository.getCamerasResponse()
        camerasResponse.data?.cameras?.forEach {
            if (it.room.isNullOrEmpty()){
                it.room = "Unknown Room"
            }
            checkedCameraItemsList.add(it)
        }
        camerasResponse.data?.cameras = checkedCameraItemsList
        return camerasResponse
    }
}