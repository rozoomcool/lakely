package com.rozoomcool.lakely.ui.presentation.screen

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.rozoomcool.lakely.domain.viewModel.AppViewModel
import com.rozoomcool.lakely.ui.presentation.AppLauncher

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AppPage(appViewModel: AppViewModel = hiltViewModel()) {
    val apps by appViewModel.state.collectAsState()
    Scaffold {
        AppLauncher(apps = apps) { packageName ->
            appViewModel.launchApp(packageName)
        }
    }
}