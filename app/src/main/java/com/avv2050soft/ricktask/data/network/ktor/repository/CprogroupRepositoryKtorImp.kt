package com.avv2050soft.ricktask.data.network.ktor.repository

import com.avv2050soft.ricktask.data.network.ktor.KtorApi
import com.avv2050soft.ricktask.data.network.ktor.KtorMapper
import com.avv2050soft.ricktask.domain.models.cameras.CamerasResponse
import com.avv2050soft.ricktask.domain.models.doors.DoorsResponse
import com.avv2050soft.ricktask.domain.repository.CprogroupRepository
import javax.inject.Inject

class CprogroupRepositoryKtorImp @Inject constructor(
    private val mapper: KtorMapper
): CprogroupRepository {
    override suspend fun getCamerasResponse(): CamerasResponse {
        return mapper.mapCamerasResponseKtorDtoToCamerasResponse(
            KtorApi.create().getCamerasResponse()
        )
    }

    override suspend fun getDoorsResponse(): DoorsResponse {
        return mapper.mapDoorsResponseKtorDtoToDoorsResponse(
            KtorApi.create().getDoorsResponse()
        )
    }
}