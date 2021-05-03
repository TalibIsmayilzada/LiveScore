package com.talib.firebaseproject

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.talib.firebaseproject.viewmodel.SecondActivityViewModel
import java.lang.IllegalArgumentException

class SecondActivityViewModelFactory(val count: Int = 5): ViewModelProvider.Factory {


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SecondActivityViewModel::class.java)){
            return SecondActivityViewModel() as T
        }
        throw IllegalArgumentException("Unknows viewmodel class")
    }
}