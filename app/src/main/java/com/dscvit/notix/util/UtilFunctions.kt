package com.dscvit.notix.util

import android.content.ContentResolver
import android.content.Context
import android.provider.Settings


object UtilFunctions {

    fun isNotificationServiceRunning(context: Context): Boolean {
        val contentResolver: ContentResolver = context.contentResolver
        val enabledNotificationListeners: String =
            Settings.Secure.getString(contentResolver, "enabled_notification_listeners")
        val packageName: String = context.packageName
        return enabledNotificationListeners.contains(packageName)
    }

}
