package com.avv2050soft.ricktask.domain.usecases

import com.avv2050soft.ricktask.domain.models.doors.DoorsResponse
import com.avv2050soft.ricktask.domain.repository.CprogroupRepository
import javax.inject.Inject

class GetDoorsResponseUseCase @Inject constructor(
    private val repository: CprogroupRepository
) {
    suspend fun getDoorsResponse(): DoorsResponse {
        val doorResponse = repository.getDoorsResponse()
        return doorResponse
    }
}