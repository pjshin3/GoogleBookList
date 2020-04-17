package com.example.mygooglebook.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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
        val detailViewModel = DetailViewModelFactory(
            title = arg.title,
            imageUrl = arg.imageUrl,
            description = arg.Description)
            .create(DetailViewModel::class.java)

        bindig.viewmodel = detailViewModel

        return bindig.root
    }
}