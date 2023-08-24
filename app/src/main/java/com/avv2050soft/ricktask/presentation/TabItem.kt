package com.avv2050soft.ricktask.presentation

import androidx.compose.runtime.Composable
import com.avv2050soft.ricktask.R
import com.avv2050soft.ricktask.presentation.ui.screens.CamerasScreen
import com.avv2050soft.ricktask.presentation.ui.screens.DoorsScreen

typealias ComposableFun = @Composable () -> Unit

sealed class TabItem(var icon: Int, var title: String, var screen: ComposableFun) {
    object Cameras : TabItem(R.drawable.baseline_video_camera_front_24, "Cameras", { CamerasScreen()})
    object Doors : TabItem(R.drawable.baseline_sensor_door_24, "Doors", { DoorsScreen() })
}
