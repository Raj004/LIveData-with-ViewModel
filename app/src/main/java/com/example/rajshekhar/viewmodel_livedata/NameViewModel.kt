package com.example.rajshekhar.viewmodel_livedata

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import retrofit2.Retrofit


/**
 * Created by rajshekhar on 16/8/18.
 */
class NameViewModel : ViewModel() {
    // Create a LiveData with a String
    private var mCurrentName: MutableLiveData<String>? = null

    val currentName: MutableLiveData<String>
        get() {
            if (mCurrentName == null) {
                mCurrentName = MutableLiveData()
            }
            return mCurrentName!!
        }
    val colorChange = MutableLiveData<Int>()

    init {
        colorChange?.value = 0xfff
    }
}














