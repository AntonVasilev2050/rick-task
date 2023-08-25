package com.avv2050soft.ricktask.domain.usecases

import com.avv2050soft.ricktask.domain.models.cameras.CamerasResponse
import com.avv2050soft.ricktask.domain.repository.CprogroupRepository
import javax.inject.Inject

class GetCamerasResponseUseCase @Inject constructor(
    private val repository: CprogroupRepository
) {
    suspend fun getCamerasResponse(): CamerasResponse {
        return repository.getCameras()
    }
}