package com.rozoomcool.lakely.domain.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rozoomcool.lakely.data.model.AppInfo
import com.rozoomcool.lakely.domain.useCase.GetInstalledAppsUseCase
import com.rozoomcool.lakely.domain.useCase.LaunchAppUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(
    private val getInstalledAppsUseCase: GetInstalledAppsUseCase,
    private val launchAppUseCase: LaunchAppUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<List<AppInfo>>(emptyList())
    val state: StateFlow<List<AppInfo>> = _state.asStateFlow()

    init {
        loadApps()
    }

    private fun loadApps() {
        viewModelScope.launch {
            _state.value = getInstalledAppsUseCase()
        }
    }

    fun launchApp(packageName: String) {
        launchAppUseCase(packageName)
    }
}