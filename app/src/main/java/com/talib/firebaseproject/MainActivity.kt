package com.talib.firebaseproject

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.messaging.FirebaseMessaging

class MainActivity : AppCompatActivity() {





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        intent.getStringExtra("course_id")?.let {
            Log.d("dasdasdas",it)
            //MAKE API Call by id
        }


        FirebaseAuth.getInstance()
        FirebaseMessaging.getInstance().token.addOnSuccessListener {
        }
    }

    override fun onStart() {
        super.onStart()


    }
}