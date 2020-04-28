package com.example.mygooglebook.List

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mygooglebook.Seach.SeachViewModel
import com.example.mygooglebook.databinding.FragmentBookListBinding
import com.example.mygooglebook.remote.data.ResponseBookData
import com.example.mygooglebook.util.observe
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class BookListFragment : Fragment(){

    private val viewmodel by sharedViewModel<SeachViewModel>()
    private val adapter = BookListAdapter()
    lateinit var binding : FragmentBookListBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBookListBinding.inflate(inflater,container,false)
        binding.listRecyclerview.adapter  = adapter
//        observeBookList()

        return binding.root
    }

//    private fun observeBookList(){
//        observe(viewmodel.result,::bookListLoad)
//    }
//
//    private fun bookListLoad(bookList : ResponseBookData?){
//        bookList?.let {
//            binding.hasList = true
//            adapter.submitList(bookList.items)
//        }
//    }
}