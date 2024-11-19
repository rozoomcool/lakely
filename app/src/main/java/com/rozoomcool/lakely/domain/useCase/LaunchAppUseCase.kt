package com.rozoomcool.lakely.domain.useCase

import android.content.Context
import androidx.core.content.ContextCompat.startActivity
import javax.inject.Inject

class LaunchAppUseCase @Inject constructor(
    private val context: Context
) {
    operator fun invoke(packageName: String) {
        val packageManager = context.packageManager
        val intent = packageManager.getLaunchIntentForPackage(packageName) ?: return
        startActivity(context, intent, null)
    }
}