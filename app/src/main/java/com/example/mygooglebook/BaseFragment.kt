package com.example.mygooglebook

import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

class BaseFragment<T>(bind : T) : Fragment(){
    private lateinit var binding : T
}