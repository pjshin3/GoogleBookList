package com.example.mygooglebook.Seach

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.mygooglebook.Home.BOOK_LIST_PAGE_INDEX
import com.example.mygooglebook.R
import com.example.mygooglebook.databinding.FragmentSearchBinding
import org.koin.android.ext.android.inject

class SeachFragment : Fragment(){

    private val viewmodel : SeachViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val bindig = FragmentSearchBinding.inflate(inflater,container,false)
        bindig.searchButton.setOnClickListener {
            navigateToListPage()
            startToSeach(bindig)
        }

        return bindig.root
    }

    fun navigateToListPage(){
        requireActivity().findViewById<ViewPager2>(R.id.view_pager).currentItem =
            BOOK_LIST_PAGE_INDEX
    }

    fun startToSeach(binding : FragmentSearchBinding){
        viewmodel.seachBookStart(binding.searchEditFrame.text.toString())
    }
}