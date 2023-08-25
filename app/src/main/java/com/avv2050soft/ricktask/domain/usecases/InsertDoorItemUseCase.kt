package com.avv2050soft.ricktask.domain.usecases

import com.avv2050soft.ricktask.domain.models.doors.DoorItem
import com.avv2050soft.ricktask.domain.repository.DatabaseRepository
import javax.inject.Inject

class InsertDoorItemUseCase @Inject constructor(
    private val repository: DatabaseRepository
) {
    suspend fun insertInDb(doorItem: DoorItem){
        repository.insertDoorItem(doorItem)
    }
}