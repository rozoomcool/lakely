package com.rozoomcool.lakely.domain.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ScreenViewModel : ViewModel() {

    var textFromSpeech: String? by mutableStateOf(null)

}