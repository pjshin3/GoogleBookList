package com.example.mygooglebook.Seach

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mygooglebook.databinding.FragmentSearchBinding

class SeachFragment : Fragment(){

    private lateinit var bindig : FragmentSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        bindig =

        return super.onCreateView(inflater, container, savedInstanceState)
    }
}