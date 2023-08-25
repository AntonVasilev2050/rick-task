package com.avv2050soft.ricktask.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.avv2050soft.ricktask.R
import com.avv2050soft.ricktask.presentation.ui.tabsView.TabItem
import com.avv2050soft.ricktask.presentation.ui.tabsView.Tabs
import com.avv2050soft.ricktask.presentation.ui.tabsView.TabsContent
import com.avv2050soft.ricktask.presentation.ui.theme.Gray
import com.avv2050soft.ricktask.presentation.ui.theme.GrayLight
import com.avv2050soft.ricktask.presentation.ui.theme.RickTaskTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RickTaskTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(
    ExperimentalPagerApi::class, ExperimentalMaterial3Api::class
)
@Composable
fun MainScreen() {
    val tabs = listOf(
        TabItem.Cameras,
        TabItem.Doors,
    )
    val pagerState = rememberPagerState()
    Scaffold(
//        topBar = { TopBar() },
    ) { padding ->
        Column {
            Surface(
                color = GrayLight,
                shadowElevation = 20.dp,
//                shape = MaterialTheme.shapes.large,
                modifier = Modifier.padding(bottom = 0.dp),
            ) {
                Column(modifier = Modifier.padding(padding)) {
                    TopBar()
                    Tabs(tabs = tabs, pagerState = pagerState)

                }
            }
            Divider(color = Gray, thickness = 2.dp)
            TabsContent(tabs = tabs, pagerState = pagerState)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}

@Composable
fun TopBar() {
    TopAppBar(
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(R.string.app_name),
                    fontSize = 21.sp,
                    textAlign = TextAlign.Center
                )
            }

        },
        modifier = Modifier.fillMaxWidth(),
        backgroundColor = GrayLight,
        contentColor = Color.Black,
        elevation = 0.dp
    )
}

@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    TopBar()
}
