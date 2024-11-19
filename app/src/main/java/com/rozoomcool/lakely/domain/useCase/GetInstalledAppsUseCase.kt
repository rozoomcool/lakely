package com.rozoomcool.lakely.domain.useCase

import com.rozoomcool.lakely.data.model.AppInfo
import com.rozoomcool.lakely.data.repository.AppRepository
import javax.inject.Inject

class GetInstalledAppsUseCase @Inject constructor(
    private val appRepository: AppRepository
) {
    operator fun invoke(): List<AppInfo> {
        return appRepository.getInstalledApps()
    }
}