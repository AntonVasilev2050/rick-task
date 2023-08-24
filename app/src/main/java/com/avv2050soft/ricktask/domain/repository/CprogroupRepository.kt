package com.avv2050soft.ricktask.domain.repository

import com.avv2050soft.ricktask.domain.models.cameras.CamerasResponse
import com.avv2050soft.ricktask.domain.models.doors.DoorsResponse

interface CprogroupRepository {
    suspend fun getCameras(): CamerasResponse
    suspend fun getDoors(): DoorsResponse
}