package com.avv2050soft.ricktask.data.mappers

import com.avv2050soft.ricktask.data.local.db_model.CameraItemDb
import com.avv2050soft.ricktask.data.local.db_model.DoorItemDb
import com.avv2050soft.ricktask.data.network.dto.CamerasResponseDto
import com.avv2050soft.ricktask.data.network.dto.DoorsResponseDto
import com.avv2050soft.ricktask.domain.models.cameras.CameraItem
import com.avv2050soft.ricktask.domain.models.cameras.CamerasResponse
import com.avv2050soft.ricktask.domain.models.doors.DoorItem
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

    fun mapCameraItemToCameraItemDb(cameraItem: CameraItem) = CameraItemDb(
        id = cameraItem.id,
        favorites = cameraItem.favorites,
        name = cameraItem.name,
        rec = cameraItem.rec,
        room = if (cameraItem.room.isNullOrEmpty()){"Unknown Room"}else{cameraItem.room},
        snapshot = cameraItem.snapshot
    )

    fun mapDoorItemToRoomItemDb(doorItem: DoorItem) = DoorItemDb(
        id = doorItem.id,
        favorites = doorItem.favorites,
        name = doorItem.name,
        room = doorItem.room,
        snapshot = doorItem.snapshot ?: null
    )

    fun mapCameraItemDbListToCameraItemList(cameraItemDbList: List<CameraItemDb>) : List<CameraItem> {
        val cameraItemList = mutableListOf<CameraItem>()
        cameraItemDbList.forEach {
            val cameraItem = CameraItem(
                favorites = it.favorites,
                id = it.id,
                name = it.name,
                rec = it.rec,
                room = it.room,
                snapshot = it.snapshot
            )
            cameraItemList.add(cameraItem)
        }
        return cameraItemList
    }

    fun mapDoorItemDbListToDoorItemList(doorItemDbList: List<DoorItemDb>): List<DoorItem>{
        val doorItemList = mutableListOf<DoorItem>()
        doorItemDbList.forEach {
            val doorItem = DoorItem(
                favorites = it.favorites,
                id = it.id,
                name = it.name,
                room = it.room,
                snapshot = it.snapshot
            )
            doorItemList.add(doorItem)
        }
        return doorItemList
    }
}