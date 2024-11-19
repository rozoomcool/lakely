package com.rozoomcool.lakely.ui.presentation.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.rozoomcool.lakely.domain.viewModel.AppViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainScreen(viewModel: AppViewModel = hiltViewModel()) {
    val apps by viewModel.state.collectAsState()
    val pageState = rememberPagerState(
        initialPage = 1
    ) { 3 }

    HorizontalPager(state = pageState, pageSize = PageSize.Fill, ) { page ->
        when (page) {
            0 -> Box(modifier = Modifier.fillMaxSize().background(Color.Red)) {
                Text("$page")
                Spacer(modifier = Modifier.height(36.dp))
            }
            1 -> HomePage()
            2 -> AppPage()
        }
    }
}