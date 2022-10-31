package com.example.yogurt.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yogurt.AppData
import com.example.yogurt.MainActivity
import com.example.yogurt.MyFragment
import com.example.yogurt.R
import com.example.yogurt.databinding.ActivityMainBinding
import com.example.yogurt.databinding.SystemFragmentBinding
import com.example.yogurt.model.System_View_Model

class system_framgment() : MyFragment() {

    override fun getTitle(): String {
        return ""
    }

    override fun Refresh() {
        Log.d("system_fragment : ","Refresh 작동")
        AppData.fragment_num = 2
    }

    override fun Exit() {

    }

    var viewModel: System_View_Model? = null
    var mBinding: SystemFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding =
            DataBindingUtil.inflate(inflater, R.layout.system_fragment, container, false)
        viewModel = ViewModelProvider(this)[System_View_Model::class.java]
        mBinding!!.systemViewmodel = viewModel
        mBinding!!.lifecycleOwner = this
        mBinding!!.batteryPack.setOnClickListener {
            AppData.electronic_type = R.drawable.battery
            MainActivity.fragment_reset(analog_battery_Fragment())
        }
        mBinding!!.motorController.setOnClickListener {
            AppData.electronic_type = R.drawable.ic_baseline_memory_24
            MainActivity.fragment_reset(analogFragment())
        }
        mBinding!!.Clustor.setOnClickListener {
            AppData.electronic_type = R.drawable.ic_baseline_computer_24
            MainActivity.fragment_reset(analogFragment())
        }
        mBinding!!.iceBox.setOnClickListener {
            AppData.electronic_type = R.drawable.ic_baseline_view_agenda_24
            MainActivity.fragment_reset(analogFragment())
        }
        mBinding!!.transmitter.setOnClickListener {
            AppData.electronic_type = R.drawable.ic_baseline_cell_tower_24
            MainActivity.fragment_reset(analogFragment())
        }
        mBinding!!.BCM.setOnClickListener {
            AppData.electronic_type = R.drawable.ic_baseline_developer_board_24
            MainActivity.fragment_reset(analogFragment())
        }
        mBinding!!.MDPS.setOnClickListener {
            AppData.electronic_type = R.drawable.ic_baseline_lens_blur_24
            MainActivity.fragment_reset(mdps_fragment())
        }
        mBinding!!.tabletPc.setOnClickListener {

        }
        return mBinding!!.root
    }

}