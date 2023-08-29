package com.avv2050soft.ricktask.data.network.retrofit.repository

import com.avv2050soft.ricktask.data.network.retrofit.api.CprogroupApi
import com.avv2050soft.ricktask.data.network.retrofit.mappers.RetrofitMapper
import com.avv2050soft.ricktask.domain.models.cameras.CamerasResponse
import com.avv2050soft.ricktask.domain.models.doors.DoorsResponse
import com.avv2050soft.ricktask.domain.repository.CprogroupRepository
import javax.inject.Inject

class CprogroupRepositoryRetrofitImpl @Inject constructor(
    private val mapper: RetrofitMapper
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