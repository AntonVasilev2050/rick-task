package com.avv2050soft.ricktask.presentation.ui.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.avv2050soft.ricktask.R
import com.avv2050soft.ricktask.domain.models.doors.DoorItem
import com.avv2050soft.ricktask.presentation.MainViewModel
import com.avv2050soft.ricktask.presentation.utils.CoilImage
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DoorsScreen() {
    val viewModel: MainViewModel = hiltViewModel()
    viewModel.getAllDoorItemsFromDb()
    var doorItems = listOf<DoorItem>()
    val doorItemListFromDb by remember { viewModel.doorItemDbState }
    val doorsResponse by remember { viewModel.doorsResponseState }
    if (doorItemListFromDb.isEmpty()) {
        viewModel.loadDoorsResponse()
        doorItems = doorsResponse?.data ?: emptyList()
        for (doorItem in doorItems) {
            viewModel.insertDoorItemInDatabase(doorItem)
        }
        Log.d("data test", "from server: $doorItems")
    } else {
        viewModel.getAllDoorItemsFromDb()
        doorItems = doorItemListFromDb
        Log.d("data test", "fromDb: $doorItems")
    }

    val refreshScope = rememberCoroutineScope()
    var refreshing by remember { mutableStateOf(false) }
    fun refresh() = refreshScope.launch {
        refreshing = true
        viewModel.loadDoorsResponse()
        doorItems = doorsResponse?.data ?: emptyList()
        Log.d("data test", "refreshed from server: $doorItems")
        refreshing = false
    }

    val state = rememberPullRefreshState(refreshing, ::refresh)
    Box(Modifier.pullRefresh(state)) {
        LazyColumn(
            modifier = Modifier
                .padding(start = 16.dp, top = 0.dp, end = 16.dp, bottom = 0.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (!refreshing) {
                items(items = doorItems) {
                    DoorViewItem(doorItem = it)
                }
            }
        }
        PullRefreshIndicator(refreshing, state, Modifier.align(Alignment.TopCenter))
    }
}

@Composable
fun DoorViewItem(doorItem: DoorItem) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 6.dp),
        shape = RoundedCornerShape(16.dp),
        shadowElevation = 8.dp,
        color = Color.White
    ) {
        Column {
            CoilImage(
                data = doorItem.snapshot,
                Modifier.fillMaxWidth(),
                contentDescription = "Camera snapshot"
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = doorItem.name,
                    modifier = Modifier.padding(
                        start = 32.dp,
                        end = 0.dp,
                        top = 32.dp,
                        bottom = 32.dp
                    )
                )
                Image(
                    painter = painterResource(id = R.drawable.lock_blue),
                    contentDescription = null,
                    modifier = Modifier.padding(end = 16.dp)
                )
            }
        }
    }
}