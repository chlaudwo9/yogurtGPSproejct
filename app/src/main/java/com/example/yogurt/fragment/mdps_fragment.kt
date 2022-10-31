package com.example.yogurt.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yogurt.AppData
import com.example.yogurt.MyFragment
import com.example.yogurt.R
import com.example.yogurt.databinding.ActivityMainBinding
import com.example.yogurt.databinding.MdpsFragmentBinding
import com.example.yogurt.model.Main_view_model
import com.example.yogurt.model.Mdps_View_Model

class mdps_fragment() : MyFragment() {

    override fun getTitle(): String {
        return ""
    }

    override fun Refresh() {
        AppData.fragment_num = 3
    }

    override fun Exit() {

    }

    var viewModel: Mdps_View_Model? = null
    var mBinding: MdpsFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding =
            DataBindingUtil.inflate(inflater, R.layout.mdps_fragment, container, false)
        viewModel = ViewModelProvider(this)[Mdps_View_Model::class.java]
        mBinding!!.mdpsViewmodel = viewModel
        mBinding!!.lifecycleOwner = this


        return mBinding!!.root
    }
}