package com.example.mygooglebook.Home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mygooglebook.R
import com.example.mygooglebook.databinding.FragmentHomviewpagerBinding
import com.google.android.material.tabs.TabLayoutMediator

class HomeViewPagerFragmentt : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomviewpagerBinding.inflate(inflater,container,false).also {

            it.viewPager.adapter = HomeViewPagerAdapter(this)

            TabLayoutMediator(it.tabs,it.viewPager){ tab, position ->
                tab.setIcon(getTabIcon(position))
                tab.text = getTitle(position)
            }.attach()

        }

        return binding.root
    }

    private fun getTabIcon(
        position: Int
    ) = when(position){
        MY_BOOK_LIST_PAGE_INDEX -> R.drawable.ic_favorite
        SEACH_PAGE_INDEX -> R.drawable.search
        else -> throw IndexOutOfBoundsException()
    }
    private fun getTitle(
        position: Int
    ) = when(position){
        MY_BOOK_LIST_PAGE_INDEX -> getString(R.string.my_Book)
        SEACH_PAGE_INDEX -> getString(R.string.search)
        else -> null
    }
}