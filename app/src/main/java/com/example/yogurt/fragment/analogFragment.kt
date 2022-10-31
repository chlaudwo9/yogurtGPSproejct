package com.example.yogurt.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yogurt.AppData
import com.example.yogurt.MainActivity
import com.example.yogurt.MyFragment
import com.example.yogurt.R
import com.example.yogurt.databinding.ActivityMainBinding
import com.example.yogurt.databinding.AnalogFragmentBinding
import com.example.yogurt.model.Analog_ViewModel

class analogFragment() : MyFragment() {

    override fun getTitle(): String {
        return ""
    }

    override fun Refresh() {
        AppData.fragment_num = 3
    }

    override fun Exit() {

    }

    var viewModel: Analog_ViewModel? = null
    var mBinding: AnalogFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding =
            DataBindingUtil.inflate(inflater, R.layout.analog_fragment, container, false)
        viewModel = ViewModelProvider(this)[Analog_ViewModel::class.java]
        mBinding!!.analogViewmodel = viewModel
        mBinding!!.lifecycleOwner = this

        viewModel?.type_path?.postValue(R.drawable.battery)

        mBinding?.insertError?.setOnClickListener {
            MainActivity.fragment_reset(error_memo_fragment())
        }

        return mBinding!!.root
    }
}

