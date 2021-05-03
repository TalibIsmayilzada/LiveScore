package com.talib.firebaseproject

import android.app.*
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.talib.firebaseproject.viewmodel.SecondActivityViewModel


class EntryFragment : Fragment(R.layout.fragment_entry) {

    lateinit var firebaseAuth: FirebaseAuth

    lateinit var notificationManager: NotificationManager
    lateinit var notificationChannel: NotificationChannel
    lateinit var builder: Notification.Builder
    private val channelId = "i.apps.notifications"
    private val description = "Test notification"

    lateinit var firestore: FirebaseFirestore
    lateinit var firebaseStorage: FirebaseStorage

    lateinit var progressDialog: ProgressDialog

    lateinit var mailEdt: EditText

    var list: MutableList<NewsModel> = mutableListOf()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        notificationManager = activity?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val secondActivityViewModel = ViewModelProvider(this).get(SecondActivityViewModel::class.java)



        mailEdt = view.findViewById(R.id.mail)

        progressDialog = ProgressDialog(requireContext())
        progressDialog.setCancelable(false)
        progressDialog.setTitle("Loading")

        firebaseAuth = FirebaseAuth.getInstance()
        firestore = FirebaseFirestore.getInstance()
        firebaseStorage = FirebaseStorage.getInstance()

        val btnSignIn: Button = view.findViewById(R.id.btnSignIn)

//        btnSignIn.setOnClickListener {
//            val mail = mailEdt.text.trim()
//            if (mail.isNotEmpty()) {
//                if (mail.length > 6) {
//                    if (Patterns.EMAIL_ADDRESS.matcher(mail).matches()) {
//                        progressDialog.show()
//                        firebaseAuth.signInWithEmailAndPassword(mail.toString(),"parol1234").addOnSuccessListener {
//                            progressDialog.dismiss()
//                            Log.d("dasdasdasd",it.user.uid)
//                        }.addOnFailureListener {
//                            progressDialog.dismiss()
//                            Log.d("dasdasdasd",it.message.toString())
//                        }
//                    } else {
//                        mailEdt.setError("Duzgun mail daxil edin")
//                    }
//                } else {
//                    mailEdt.setError("parol 6dan cox olmalidir")
//                }
//            } else {
//                mailEdt.setError("Bos ola bilmez")
//            }
//
//        }

        btnSignIn.setOnClickListener {
            val intent = Intent(requireActivity(), MainActivity::class.java)

            // FLAG_UPDATE_CURRENT specifies that if a previous
            // PendingIntent already exists, then the current one
            // will update it with the latest intent
            // 0 is the request code, using it later with the
            // same method again will get back the same pending
            // intent for future reference
            // intent passed here is to our afterNotification class
            val pendingIntent = PendingIntent.getActivity(requireActivity(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)

            // RemoteViews are used to use the content of
            // some different layout apart from the current activity layout

            // checking if android version is greater than oreo(API 26) or not
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                notificationChannel = NotificationChannel(channelId, description, NotificationManager.IMPORTANCE_HIGH)
                notificationChannel.enableLights(true)
                notificationChannel.lightColor = Color.GREEN
                notificationChannel.enableVibration(false)
                notificationManager.createNotificationChannel(notificationChannel)



                builder = Notification.Builder(requireContext(), channelId)
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setContentIntent(pendingIntent)
            } else {

                builder = Notification.Builder(requireContext())
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setContentIntent(pendingIntent)
            }
            notificationManager.notify(1234, builder.build())


        }
    }

}