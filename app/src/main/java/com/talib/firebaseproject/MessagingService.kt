package com.talib.firebaseproject

import android.app.Service
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MessagingService: FirebaseMessagingService() {

    override fun onMessageReceived(p0: RemoteMessage) {
        super.onMessageReceived(p0)
        Log.d("dasdasdas",p0.notification?.title.toString())
        Log.d("dasdasdas",p0.notification?.body.toString())
        Log.d("dasdasdas",p0.notification?.imageUrl.toString())
    }
}