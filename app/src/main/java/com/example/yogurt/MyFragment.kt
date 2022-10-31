package com.example.yogurt

import androidx.fragment.app.Fragment

abstract class MyFragment : Fragment() {
    abstract fun getTitle() : String
    abstract fun Refresh()
    abstract fun Exit()
}