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
    private lateinit var binding : FragmentSearchBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSearchBinding.inflate(inflater,container,false)
        binding.searchButton.setOnClickListener(clickListner)

        return binding.root
    }

    fun navigateToListPage(){
        requireActivity().findViewById<ViewPager2>(R.id.view_pager).currentItem =
            BOOK_LIST_PAGE_INDEX
    }

    fun startToSeach(binding : FragmentSearchBinding){
        viewmodel.seachBookStart(binding.searchEditFrame.text.toString())
    }

    fun View.hideKeyboard(){
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken,0)
    }

    private val clickListner = View.OnClickListener {
        when (it.id) {
            R.id.search_button -> {
                binding.root.hideKeyboard()
                navigateToListPage()
                startToSeach(binding)
            }
        }
    }
}