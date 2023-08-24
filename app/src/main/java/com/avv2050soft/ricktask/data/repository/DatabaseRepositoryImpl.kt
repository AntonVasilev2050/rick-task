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
        TODO("Not yet implemented")
    }

    override suspend fun insertDoorItem(doorItem: DoorItem) {
        TODO("Not yet implemented")
    }

    override suspend fun getAllCameraItems(): List<CameraItem> {
        TODO("Not yet implemented")
    }

    override suspend fun getAllDoorItems(): List<DoorItem> {
        TODO("Not yet implemented")
    }
}