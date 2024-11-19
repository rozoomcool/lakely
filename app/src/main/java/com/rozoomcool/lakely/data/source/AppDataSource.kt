package com.rozoomcool.lakely.data.source

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import com.rozoomcool.lakely.data.model.AppInfo
import javax.inject.Inject

class AppDataSource @Inject constructor(private val context: Context) {
    @SuppressLint("QueryPermissionsNeeded")
    fun getInstalledApps(): List<AppInfo> {
        val intent = Intent(Intent.ACTION_MAIN, null).apply {
            addCategory(Intent.CATEGORY_LAUNCHER)
        }
        val packageManager = context.packageManager
        val activities = packageManager.queryIntentActivities(intent, 0)

        return activities.map {
            AppInfo(
                label = it.loadLabel(packageManager).toString(),
                packageName = it.activityInfo.packageName,
                icon = it.loadIcon(packageManager)
            )
        }
    }
}