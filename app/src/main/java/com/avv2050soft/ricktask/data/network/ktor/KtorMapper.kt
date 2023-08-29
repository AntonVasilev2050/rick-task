package com.avv2050soft.ricktask.data.network.ktor

import com.avv2050soft.ricktask.domain.models.cameras.CamerasResponse
import com.avv2050soft.ricktask.domain.models.doors.DoorsResponse

class KtorMapper {
    fun mapCamerasResponseKtorDtoToCamerasResponse(camerasResponseKtorDto: CamerasResponseKtorDto) =
        CamerasResponse(
            data = camerasResponseKtorDto.data,
            success = camerasResponseKtorDto.success
        )

    fun mapDoorsResponseKtorDtoToDoorsResponse(doorsResponseKtorDto: DoorsResponseKtorDto) =
        DoorsResponse(
            data = doorsResponseKtorDto.data,
            success = doorsResponseKtorDto.success
        )
}