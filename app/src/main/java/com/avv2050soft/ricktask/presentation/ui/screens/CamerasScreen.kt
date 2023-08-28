package com.avv2050soft.ricktask.presentation.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.avv2050soft.ricktask.R
import com.avv2050soft.ricktask.domain.models.cameras.CameraItem
import com.avv2050soft.ricktask.presentation.MainViewModel
import com.avv2050soft.ricktask.presentation.utils.CoilImage

@Composable
fun CamerasScreen() {
    val viewModel: MainViewModel = hiltViewModel()
    viewModel.getAllCameraItemsFromDb()
    val cameraItemListFromDb by remember { viewModel.cameraItemsDbState }
    var cameraItems = listOf<CameraItem>()
    val camerasResponse by remember { viewModel.camerasResponseState }
    if (cameraItemListFromDb.isNotEmpty()) {
        cameraItems = cameraItemListFromDb
    } else {
        viewModel.loadCamerasResponse()
        cameraItems = camerasResponse?.data?.cameras ?: emptyList()
        for (cameraItem in cameraItems) {
            viewModel.insertCameraItemInDatabase(cameraItem)
        }
    }

    val roomList = camerasResponse?.data?.room
    Column {
        Text(text = "Living Room", modifier = Modifier.padding(16.dp))
        LazyColumn(
            modifier = Modifier
                .padding(start = 16.dp, top = 0.dp, end = 16.dp, bottom = 0.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(items = cameraItems) {
                CameraViewItem(cameraItem = it, roomList = roomList)
            }
        }
    }
}

@Composable
fun CameraViewItem(cameraItem: CameraItem, roomList: List<String>?) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 6.dp),
        shape = RoundedCornerShape(16.dp),
        shadowElevation = 8.dp,
        color = Color.White
    ) {
        Column {
            if (cameraItem.room == roomList?.get(0)) {
                CoilImage(
                    data = cameraItem.snapshot,
                    Modifier.fillMaxWidth(),
                    contentDescription = "Camera snapshot"
                )
                Text(text = cameraItem.name, modifier = Modifier.padding(16.dp))
            }
        }
        if (cameraItem.room == roomList?.get(0) && cameraItem.rec) {
            Image(
                painter = painterResource(id = R.drawable.rec),
                contentDescription = null,
                modifier = Modifier.padding(20.dp),
                alignment = Alignment.TopStart
            )
        }
        if (cameraItem.room == roomList?.get(0) && cameraItem.favorites) {
            Image(
                painter = painterResource(id = R.drawable.star),
                contentDescription = null,
                modifier = Modifier.padding(20.dp),
                alignment = Alignment.TopEnd
            )
        }
    }
}