package com.talib.firebaseproject

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import com.onesignal.OneSignal

class MyApp: Application() {

    override fun onCreate() {
        super.onCreate()

        createNotificationChannel()
        // Enable verbose OneSignal logging to debug issues if needed.
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);

        // OneSignal Initialization
        OneSignal.initWithContext(this);
        OneSignal.setAppId("937a2abf-7c96-404b-b9e0-82bac16c4842")
        OneSignal.setNotificationOpenedHandler { result->
            result.notification.additionalData.optString("course_id").let {courseID->
                val intent = Intent(applicationContext,MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                intent.putExtra("course_id",courseID)
                startActivity(intent)
            }
        }
    }

    private fun createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library

    }
}