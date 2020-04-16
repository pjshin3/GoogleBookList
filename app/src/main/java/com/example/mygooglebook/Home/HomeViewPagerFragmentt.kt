package com.example.mygooglebook.Home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mygooglebook.databinding.FragmentHomviewpagerBinding

class HomeViewPagerFragmentt : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomviewpagerBinding.inflate(inflater,container,false)
        val viewpage = binding.viewPager

        viewpage.adapter = HomeViewPagerAdapter(this)

        return binding.root
    }

}