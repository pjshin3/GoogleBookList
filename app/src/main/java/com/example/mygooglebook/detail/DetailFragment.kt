package com.example.mygooglebook.detail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.example.mygooglebook.databinding.FragmentBookDetailBinding

class DetailFragment : Fragment(){

   private val arg : DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val bindig = FragmentBookDetailBinding.inflate(inflater,container,false)

        Log.e("DetailFragment","${arg.title}")
        
        return bindig.root
    }
}