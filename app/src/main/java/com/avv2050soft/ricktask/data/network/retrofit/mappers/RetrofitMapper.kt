package com.avv2050soft.ricktask.data.network.retrofit.mappers

import com.avv2050soft.ricktask.data.network.retrofit.dto.CamerasResponseDto
import com.avv2050soft.ricktask.data.network.retrofit.dto.DoorsResponseDto
import com.avv2050soft.ricktask.domain.models.cameras.CamerasResponse
import com.avv2050soft.ricktask.domain.models.doors.DoorsResponse

class RetrofitMapper {
    fun mapCamerasResponseDtoToCamerasResponse(camerasResponseDto: CamerasResponseDto) =
        CamerasResponse(
            data = camerasResponseDto.data,
            success = camerasResponseDto.success
        )

    fun mapDoorsResponseDtoToDoorsResponse(doorsResponseDto: DoorsResponseDto) =
        DoorsResponse(
            data = doorsResponseDto.data,
            success = doorsResponseDto.success
        )
}