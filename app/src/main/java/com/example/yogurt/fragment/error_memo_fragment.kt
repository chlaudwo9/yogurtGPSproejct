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
import com.example.yogurt.databinding.ErrorMemoFragmentBinding
import com.example.yogurt.model.ErrorMemo_Model

class error_memo_fragment() : MyFragment() {

    override fun getTitle(): String {
        return ""
    }

    override fun Refresh() {
        AppData.fragment_num = 4
    }

    override fun Exit() {

    }

    var viewModel: ErrorMemo_Model? = null
    var mBinding: ErrorMemoFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding =
            DataBindingUtil.inflate(inflater, R.layout.error_memo_fragment, container, false)
        viewModel = ViewModelProvider(this)[ErrorMemo_Model::class.java]
        mBinding!!.errorMemoViewmodel = viewModel
        mBinding!!.lifecycleOwner = this




        return mBinding!!.root
    }
}