package com.avv2050soft.ricktask.data.repository

import android.content.Context
import com.avv2050soft.ricktask.data.local.db.CprogroupDatabase
import com.avv2050soft.ricktask.data.mappers.CprogroupMapper
import com.avv2050soft.ricktask.domain.models.cameras.CameraItem
import com.avv2050soft.ricktask.domain.models.doors.DoorItem
import com.avv2050soft.ricktask.domain.repository.DatabaseRepository
import javax.inject.Inject

class DatabaseRepositoryImpl @Inject constructor(
    context: Context,
    private val mapper: CprogroupMapper
): DatabaseRepository {

    private val db = CprogroupDatabase.getInstance(context)

    override suspend fun insertCameraItem(cameraItem: CameraItem) {
        val cameraItemDb = mapper.mapCameraItemToCameraItemDb(cameraItem)
        db.camerasDao().insert(cameraItemDb)
    }

    override suspend fun insertDoorItem(doorItem: DoorItem) {
        val doorItemDb = mapper.mapDoorItemToRoomItemDb(doorItem)
        db.doorsDao().insert(doorItemDb)
    }

    override suspend fun getAllCameraItems(): List<CameraItem> {
        return  mapper.mapCameraItemDbListToCameraItemList(db.camerasDao().getAllCamerasItems())

    }

    override suspend fun getAllDoorItems(): List<DoorItem> {
        return mapper.mapDoorItemDbListToDoorItemList(db.doorsDao().getAllDoorItems())
    }
}