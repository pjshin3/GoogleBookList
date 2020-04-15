package com.example.mygooglebook.List

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.observe
import androidx.fragment.app.Fragment
import com.example.mygooglebook.databinding.FragmentBookListBinding
import org.koin.android.ext.android.inject

class BookListFragment : Fragment(){

    private val viewmodel : BookListViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentBookListBinding.inflate(inflater,container,false)
        val adapter = BookListFragmentAdapter()
        binding.listRecyclerview.adapter  = adapter
        observeBookList(binding,adapter)

        return binding.root
    }

    fun observeBookList(binding : FragmentBookListBinding ,adapter : BookListFragmentAdapter){
        viewmodel.bookList.observe(viewLifecycleOwner){
            binding.hasList = !it.items.isNullOrEmpty()
            adapter.submitList(it.items)
        }
    }

}