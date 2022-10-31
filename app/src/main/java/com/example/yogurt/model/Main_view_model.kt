package com.example.yogurt.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import java.util.*
import kotlin.collections.ArrayList


class Main_view_model (application: Application) : AndroidViewModel(application){
    var visible_count:MutableLiveData<String> = MutableLiveData<String>()
    var page:MutableLiveData<String> = MutableLiveData<String>()
    var max_page:MutableLiveData<String> = MutableLiveData<String>()
    var count:MutableLiveData<String> = MutableLiveData<String>()
    var SList:MutableLiveData<ArrayList<Byte>> = MutableLiveData<ArrayList<Byte>>()
    var onoff:MutableLiveData<ArrayList<Int>> = MutableLiveData<ArrayList<Int>>()
    var nameList:MutableLiveData<ArrayList<String>> = MutableLiveData<ArrayList<String>>()
    var tt:MutableLiveData<String> = MutableLiveData<String>()
    var select:MutableLiveData<Int> = MutableLiveData<Int>()
    var address_name:MutableLiveData<String> = MutableLiveData<String>()
    var lati:MutableLiveData<String> = MutableLiveData<String>()
    var longti:MutableLiveData<String> = MutableLiveData<String>()


    init {
        page.value = "1"
        max_page.value = "1"
        visible_count.value = "7"
    }
}
