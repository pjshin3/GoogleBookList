package com.example.mygooglebook.Home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.mygooglebook.BaseFragment
import com.example.mygooglebook.R
import com.example.mygooglebook.databinding.FragmentHomviewpagerBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class HomeViewPagerFragmentt
    : BaseFragment<FragmentHomviewpagerBinding>(R.layout.fragment_homviewpager) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(bindig){
            viewPager.adapter = HomeViewPagerAdapter(this@HomeViewPagerFragmentt)
            tabLayoutAttach(tabs,viewPager)
        }
    }

    private fun tabLayoutAttach(
        tabs: TabLayout,
        viewPager: ViewPager2
    ){
        TabLayoutMediator(tabs,viewPager){ tab, position ->
            tab.setIcon(getTabIcon(position))
            tab.text = getTitle(position)
        }.attach()
    }

    private fun getTabIcon( position: Int ) = when(position){
        MY_BOOK_LIST_PAGE_INDEX -> R.drawable.ic_favorite
        SEACH_PAGE_INDEX -> R.drawable.search
        else -> throw IndexOutOfBoundsException()
    }
    private fun getTitle( position: Int ) = when(position){
        MY_BOOK_LIST_PAGE_INDEX -> getString(R.string.my_Book)
        SEACH_PAGE_INDEX -> getString(R.string.search)
        else -> null
    }
}