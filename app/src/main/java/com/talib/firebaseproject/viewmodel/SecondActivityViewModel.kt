package com.talib.firebaseproject.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SecondActivityViewModel: ViewModel() {

    var count = MutableLiveData<Int>()


    init {
        count.value = 0
    }


    fun increase(){
        count.value = count.value?.plus(1)
    }


}