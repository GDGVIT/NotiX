package com.dscvit.notix

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.appcompat.app.AppCompatActivity
import com.dscvit.notix.util.UtilFunctions.isNotificationServiceRunning

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getNotificationAccess()
    }

    private fun getNotificationAccess() {
        val isNotificationServiceRunning: Boolean = isNotificationServiceRunning(this)
        if (!isNotificationServiceRunning) {
            startActivity(Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS))
        }
    }
}