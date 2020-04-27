package com.example.mygooglebook.MyBookList

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import com.example.mygooglebook.database.Book
import com.example.mygooglebook.databinding.FragmentMyBookListBinding
import com.example.mygooglebook.util.observe
import kotlinx.android.synthetic.main.fragment_book_detail.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class MyBookListFragment : Fragment(){
    private val viewmodel : MyBookListViewModel by sharedViewModel()
    private val adapter = MyBookListAdapter()
    private lateinit var binding : FragmentMyBookListBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyBookListBinding.inflate(inflater,container,false)
        binding.listRecyclerview.adapter = adapter
        myBookListObserve()

        return binding.root
    }

    private fun myBookListObserve(){
        observe(viewmodel.result, ::bookListChange)
    }
    //TODO 룸에 넣어진 값을 보여주는 로직 개발 필요
    private fun bookListChange(list : List<Book>?){
        list?.let {
            binding.hasitem = !it.isNullOrEmpty()
            adapter.submitList(it)
        }
    }
}