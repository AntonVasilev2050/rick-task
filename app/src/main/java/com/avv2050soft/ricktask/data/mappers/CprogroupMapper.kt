package com.avv2050soft.ricktask.data.mappers

import com.avv2050soft.ricktask.data.network.dto.CamerasResponseDto
import com.avv2050soft.ricktask.data.network.dto.DoorsResponseDto
import com.avv2050soft.ricktask.domain.models.cameras.CamerasResponse
import com.avv2050soft.ricktask.domain.models.doors.DoorsResponse

class CprogroupMapper {
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