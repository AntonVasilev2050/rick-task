package com.avv2050soft.ricktask.presentation

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.avv2050soft.ricktask.domain.models.cameras.CamerasResponse
import com.avv2050soft.ricktask.domain.models.doors.DoorsResponse
import com.avv2050soft.ricktask.domain.usecases.GetCamerasResponseUseCase
import com.avv2050soft.ricktask.domain.usecases.GetDoorsResponseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getCamerasResponseUseCase: GetCamerasResponseUseCase,
    private val getDoorsResponseUseCase: GetDoorsResponseUseCase
) : ViewModel() {
    private var camerasResponse: CamerasResponse? = null
    var camerasResponseState: MutableState<CamerasResponse?> =
        mutableStateOf(camerasResponse)

    private var doorsResponse: DoorsResponse? = null
    var doorsResponseState: MutableState<DoorsResponse?> = mutableStateOf(doorsResponse)

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

                }
        }
    }
}