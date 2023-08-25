package com.avv2050soft.ricktask.presentation

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.avv2050soft.ricktask.domain.models.cameras.CameraItem
import com.avv2050soft.ricktask.domain.models.cameras.CamerasResponse
import com.avv2050soft.ricktask.domain.models.doors.DoorItem
import com.avv2050soft.ricktask.domain.models.doors.DoorsResponse
import com.avv2050soft.ricktask.domain.usecases.GetAllCameraItemsUseCase
import com.avv2050soft.ricktask.domain.usecases.GetAllDoorItemsUseCase
import com.avv2050soft.ricktask.domain.usecases.GetCamerasResponseUseCase
import com.avv2050soft.ricktask.domain.usecases.GetDoorsResponseUseCase
import com.avv2050soft.ricktask.domain.usecases.InsertCameraItemUseCase
import com.avv2050soft.ricktask.domain.usecases.InsertDoorItemUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getCamerasResponseUseCase: GetCamerasResponseUseCase,
    private val getDoorsResponseUseCase: GetDoorsResponseUseCase,
    private val insertCameraItemUseCase: InsertCameraItemUseCase,
    private val insertDoorItemUseCase: InsertDoorItemUseCase,
    private val getAllCameraItemsUseCase: GetAllCameraItemsUseCase,
    private val getAllDoorItemsUseCase: GetAllDoorItemsUseCase
) : ViewModel() {
    private var camerasResponse: CamerasResponse? = null
    var camerasResponseState: MutableState<CamerasResponse?> =
        mutableStateOf(camerasResponse)

    private var doorsResponse: DoorsResponse? = null
    var doorsResponseState: MutableState<DoorsResponse?> = mutableStateOf(doorsResponse)

    private var cameraItemsDb: List<CameraItem> = emptyList()
    var cameraItemsDbState: MutableState<List<CameraItem>> = mutableStateOf(cameraItemsDb)

    private var doorItemDb: List<DoorItem> = emptyList()
    var doorItemDbState: MutableState<List<DoorItem>> = mutableStateOf(doorItemDb)

    fun loadCamerasResponse() {
        viewModelScope.launch {
            kotlin.runCatching {
                camerasResponse = getCamerasResponseUseCase.getCamerasResponse()
            }
                .onSuccess {
                    camerasResponseState.value = camerasResponse
                }
                .onFailure {
                    Log.d("data_test", it.message.toString())
                }
        }
    }

    fun loadDoorsResponse() {
        viewModelScope.launch {
            kotlin.runCatching {
                doorsResponse = getDoorsResponseUseCase.getDoorsResponse()
            }
                .onSuccess {
                    doorsResponseState.value = doorsResponse
                }
                .onFailure {
                    Log.d("data_test", it.message.toString())
                }
        }
    }

    fun insertCameraItemInDatabase(cameraItem: CameraItem) {
        viewModelScope.launch {
            insertCameraItemUseCase.insertInDb(cameraItem)
        }
    }

    fun insertDoorItemInDatabase(doorItem: DoorItem) {
        viewModelScope.launch {
            insertDoorItemUseCase.insertInDb(doorItem)
        }
    }

    fun getAllCameraItemsFromDb() {
        viewModelScope.launch {
            kotlin.runCatching {
                cameraItemsDb = getAllCameraItemsUseCase.getAllCameraItems()
            }
                .onSuccess {
                    cameraItemsDbState.value = cameraItemsDb
                }
                .onFailure {
                    Log.d("data_test", it.message.toString())
                }
        }
    }

    fun getAllDoorItemsFromDb() {
        viewModelScope.launch {
            kotlin.runCatching {
                doorItemDb = getAllDoorItemsUseCase.getAllDoorItems()
            }
                .onSuccess {
                    doorItemDbState.value = doorItemDb
                }
                .onFailure {
                    Log.d("data_test", it.message.toString())
                }
        }

    }
}