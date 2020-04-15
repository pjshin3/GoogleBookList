package com.example.mygooglebook.Home

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.mygooglebook.List.BookListFragment
import com.example.mygooglebook.Seach.SeachFragment
import java.lang.IndexOutOfBoundsException


const val SEACH_PAGE_INDEX = 0
const val BOOK_LIST_PAGE_INDEX = 1
class HomeViewPagerAdapter (fragment: Fragment) : FragmentStateAdapter(fragment){

    private val viewPagerFragmentCreator: Map<Int , () -> Fragment> = mapOf(
        SEACH_PAGE_INDEX to {SeachFragment()},
        BOOK_LIST_PAGE_INDEX to {BookListFragment()}
    )

    override fun getItemCount(): Int = viewPagerFragmentCreator.size
    override fun createFragment(position: Int): Fragment {
        return viewPagerFragmentCreator[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }

}