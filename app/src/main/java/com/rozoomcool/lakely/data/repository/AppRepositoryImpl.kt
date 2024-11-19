package com.rozoomcool.lakely.data.repository

import com.rozoomcool.lakely.data.model.AppInfo
import com.rozoomcool.lakely.data.source.AppDataSource
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(
    private val appDataSource: AppDataSource
) : AppRepository {
    override fun getInstalledApps(): List<AppInfo> {
        return appDataSource.getInstalledApps()
    }
}