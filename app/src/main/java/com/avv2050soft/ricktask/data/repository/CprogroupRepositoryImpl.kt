package com.avv2050soft.ricktask.data.repository

import com.avv2050soft.ricktask.data.mappers.CprogroupMapper
import com.avv2050soft.ricktask.data.network.api.CprogroupApi
import com.avv2050soft.ricktask.domain.models.cameras.CamerasResponse
import com.avv2050soft.ricktask.domain.models.doors.DoorsResponse
import com.avv2050soft.ricktask.domain.repository.CprogroupRepository
import javax.inject.Inject

class CprogroupRepositoryImpl @Inject constructor(
    private val mapper: CprogroupMapper
) : CprogroupRepository {
    override suspend fun getCameras(): CamerasResponse {
        return mapper.mapCamerasResponseDtoToCamerasResponse(
            CprogroupApi.create().getCamerasResponse()
        )
    }

    override suspend fun getDoors(): DoorsResponse {
        return mapper.mapDoorsResponseDtoToDoorsResponse(
            CprogroupApi.create().getDoorsResponse()
        )
    }
}