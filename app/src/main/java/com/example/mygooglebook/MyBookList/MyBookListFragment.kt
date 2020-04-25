package com.example.mygooglebook.MyBookList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mygooglebook.data.Book
import com.example.mygooglebook.databinding.FragmentMyBookListBinding
import com.example.mygooglebook.util.observe
import org.koin.android.ext.android.inject

class MyBookListFragment : Fragment(){

    private val viewmodel : MyBookListViewModel by inject()
    private val adapter = MyBookListAdapter()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMyBookListBinding.inflate(inflater,container,false)

        binding.listRecyclerview.adapter = adapter
        viewmodel.getMyBookList()

        return binding.root
    }

    private fun myBookListObserve(){

    }
    private fun bookListChange(list : List<Book>){
        adapter.submitList(list)
    }
}