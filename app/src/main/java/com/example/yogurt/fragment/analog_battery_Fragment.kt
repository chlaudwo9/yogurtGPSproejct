package com.example.yogurt.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yogurt.AppData
import com.example.yogurt.MainActivity
import com.example.yogurt.MyFragment
import com.example.yogurt.R
import com.example.yogurt.databinding.ActivityMainBinding
import com.example.yogurt.databinding.AnalogFragmentBatteryBinding
import com.example.yogurt.model.Analog_battery_ViewModel

class analog_battery_Fragment() : MyFragment() {

    override fun getTitle(): String {
        return ""
    }

    override fun Refresh() {
        AppData.fragment_num = 3
    }

    override fun Exit() {

    }

    var viewModel: Analog_battery_ViewModel? = null
    var mBinding: AnalogFragmentBatteryBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding =
            DataBindingUtil.inflate(inflater, R.layout.analog_fragment_battery, container, false)
        viewModel = ViewModelProvider(this)[Analog_battery_ViewModel::class.java]
        mBinding!!.analogBatteryViewmovdel = viewModel
        mBinding!!.lifecycleOwner = this

        mBinding?.insertError?.setOnClickListener {
            MainActivity.fragment_reset(error_memo_fragment())
        }

        return mBinding!!.root
    }
}