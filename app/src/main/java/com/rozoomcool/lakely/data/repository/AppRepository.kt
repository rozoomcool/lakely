package com.rozoomcool.lakely.data.repository

import com.rozoomcool.lakely.data.model.AppInfo

interface AppRepository {
    fun getInstalledApps(): List<AppInfo>
}