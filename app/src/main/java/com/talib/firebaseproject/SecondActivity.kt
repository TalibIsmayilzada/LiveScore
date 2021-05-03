package com.talib.firebaseproject

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.talib.firebaseproject.databinding.ActivitySecondBinding
import com.talib.firebaseproject.viewmodel.SecondActivityViewModel

class SecondActivity : AppCompatActivity() {

    lateinit var secondActivityViewModel: SecondActivityViewModel

    lateinit var secondBinding: ActivitySecondBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        secondBinding = DataBindingUtil.setContentView(this,R.layout.activity_second)

        secondActivityViewModel = ViewModelProvider(this).get(SecondActivityViewModel::class.java)

        secondBinding.viewModel = secondActivityViewModel
        secondBinding.lifecycleOwner = this


    }
}