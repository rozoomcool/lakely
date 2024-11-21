package com.rozoomcool.lakely.ui.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.rozoomcool.lakely.domain.viewModel.ScreenViewModel
import com.rozoomcool.lakely.ui.presentation.components.RequestPermissionComponent
import com.rozoomcool.lakely.ui.presentation.components.SpeechToText

@Composable
fun WorkPage() {
    var permissionGranted by remember { mutableStateOf(false) }

    if (permissionGranted) {
        SpeechToText()
    } else {
        RequestPermissionComponent(onPermissionGranted = {
            permissionGranted = true
        })
    }
}
