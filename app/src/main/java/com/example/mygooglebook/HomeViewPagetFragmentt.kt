package com.example.mygooglebook

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mygooglebook.databinding.FragmentHomviewpagerBinding

class HomeViewPagetFragmentt : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomviewpagerBinding.inflate(inflater,container,false)
        val viewpage = binding.viewPager


        //TODO LIST
        //뷰페이저 를 완성해야됨.
        
        return binding.root
    }

}