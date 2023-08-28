package com.avv2050soft.ricktask.presentation.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import com.avv2050soft.ricktask.domain.models.doors.DoorItem
import com.avv2050soft.ricktask.presentation.MainViewModel
import com.avv2050soft.ricktask.presentation.utils.CoilImage

@Composable
fun DoorsScreen() {
    val viewModel: MainViewModel = hiltViewModel()
    viewModel.getAllDoorItemsFromDb()
    val doorItemListFromDb by remember { viewModel.doorItemDbState }
    var doorItems = listOf<DoorItem>()
    viewModel.loadDoorsResponse()
    val doorsResponse by remember { viewModel.doorsResponseState }
    if (doorItemListFromDb.isNotEmpty()){
        doorItems = doorItemListFromDb
    }else{
        viewModel.loadDoorsResponse()
        doorItems = doorsResponse?.data ?: emptyList()
        for (doorItem in doorItems){
            viewModel.insertDoorItemInDatabase(doorItem)
        }
    }
    LazyColumn(
        modifier = Modifier
            .padding(start = 16.dp, top = 0.dp, end = 16.dp, bottom = 0.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        doorsResponse?.let {
            items(items = doorItems) {
                DoorViewItem(doorItem = it)
            }
        }
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
                Text(text = doorItem.name, modifier = Modifier.padding(32.dp))
                Image(
                    painter = painterResource(id = R.drawable.lock_blue),
                    contentDescription = null,
                    modifier = Modifier.padding(end = 16.dp)
                )
            }
        }
    }
}