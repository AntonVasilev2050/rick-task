package com.avv2050soft.ricktask.domain.usecases

import com.avv2050soft.ricktask.domain.models.doors.DoorItem
import com.avv2050soft.ricktask.domain.models.doors.DoorsResponse
import com.avv2050soft.ricktask.domain.repository.CprogroupRepository
import javax.inject.Inject

class GetDoorsResponseUseCase @Inject constructor(
    private val repository: CprogroupRepository
) {
    suspend fun getDoorsResponse(): DoorsResponse {
        val checkedDoorItemsList = mutableListOf<DoorItem>()
        val doorResponse = repository.getDoorsResponse()
        doorResponse.data.forEach {
            if (it.room.isNullOrEmpty()){
                it.room = "Unknown Room"
            }
            checkedDoorItemsList.add(it)
        }
        return doorResponse
    }
}