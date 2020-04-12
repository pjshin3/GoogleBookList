package com.example.mygooglebook.List

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.observe
import androidx.fragment.app.Fragment
import com.example.mygooglebook.databinding.FragmentBookListBinding
import org.koin.android.ext.android.inject

class ListFragment : Fragment(){

    private val viewmodel : ListViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentBookListBinding.inflate(inflater,container,false)

        return binding.root
    }

    fun observeBookList(){
        viewmodel.bookList.observe(viewLifecycleOwner) {
            // TODO
            //  리졸트 받는 값을 어뎁터에 연결시켜줘야 함.
        }
    }

}