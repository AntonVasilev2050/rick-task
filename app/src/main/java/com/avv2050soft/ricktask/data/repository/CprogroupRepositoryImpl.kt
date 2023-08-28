package com.avv2050soft.ricktask.data.repository

import com.avv2050soft.ricktask.data.local.room.mappers.RoomMapper
import com.avv2050soft.ricktask.data.network.api.CprogroupApi
import com.avv2050soft.ricktask.domain.models.cameras.CamerasResponse
import com.avv2050soft.ricktask.domain.models.doors.DoorsResponse
import com.avv2050soft.ricktask.domain.repository.CprogroupRepository
import javax.inject.Inject

class CprogroupRepositoryImpl @Inject constructor(
    private val mapper: RoomMapper
) : CprogroupRepository {
    override suspend fun getCamerasResponse(): CamerasResponse {
        return mapper.mapCamerasResponseDtoToCamerasResponse(
            CprogroupApi.create().getCamerasResponse()
        )
    }

    override suspend fun getDoorsResponse(): DoorsResponse {
        return mapper.mapDoorsResponseDtoToDoorsResponse(
            CprogroupApi.create().getDoorsResponse()
        )
    }
}