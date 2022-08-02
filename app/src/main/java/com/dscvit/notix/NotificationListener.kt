package com.dscvit.notix

import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.util.Log
import com.dscvit.notix.util.SpamClassifier.spamClassifyMessage

class NotificationListener : NotificationListenerService() {

    companion object {
        const val TAG = "NotificationListener"
    }

    override fun onNotificationPosted(newNotification: StatusBarNotification) {
        // Building the input message string
        var message = ""
        newNotification.notification.extras.apply {
            message += getString("android.title") + " "
            message += getString("android.text")
        }

        // Classify the notification
        val isSpam: Boolean = spamClassifyMessage(this, message)

        // Logging the notification
        Log.i(
            TAG,
            "------------OnNotificationPosted" +
                    "\n" + "newNotification: " + newNotification +
                    "\n" + "newNotification.notification: " + newNotification.notification +
                    "\n" + "ID :" + newNotification.id +
                    "\n" + "title: " + newNotification.notification.extras.getString("android.title") +
                    "\n" + "text: " + newNotification.notification.extras.getString("android.text") +
                    "\n" + "tickerText: " + newNotification.notification.tickerText +
                    "\n" + "postedTime: " + newNotification.postTime +
                    "\n" + "packageName: " + newNotification.packageName +
                    "\n" + "isSpam: " + isSpam.toString()

            /*"-------- onNotificationPosted(): " + "ID :" + newNotification.id +
                    "\n" + newNotification.notification.extras.getString("android.title") +
                    "\n"+ newNotification.notification.extras.getString("android.text") +
                    "\n"+ newNotification.notification.tickerText +
                    "\n" + newNotification.packageName */

        )
    }
}