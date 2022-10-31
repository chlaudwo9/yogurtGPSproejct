package com.example.yogurt.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import java.util.*
import kotlin.collections.ArrayList


class Analog_ViewModel (application: Application) : AndroidViewModel(application){
    var address_name:MutableLiveData<String> = MutableLiveData<String>()
    var type_path:MutableLiveData<Int> = MutableLiveData<Int>()

}
