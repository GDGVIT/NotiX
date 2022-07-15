package com.dscvit.notix.util

import android.content.Context
import com.dscvit.notix.util.Constants.SPAM_POINT
import org.tensorflow.lite.support.label.Category

object SpamClassifier {
    fun spamClassifyMessage(context: Context, message: String) : Boolean {
        // Loading the ML model for spam detection
        val client = SpamClassificationClient(context)
        client.load()

        // Predicts if the notification is a spam notification
        var isSpam = false
        if (message.trim() != "") {
            val results: List<Category> = client.classify(message)
            val score = results[1].score
            if (score > SPAM_POINT) {
                isSpam = true
            }
        }
        return isSpam
    }
}