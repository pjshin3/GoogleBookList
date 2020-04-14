package com.example.mygooglebook.List

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.observe
import androidx.fragment.app.Fragment
import com.example.mygooglebook.databinding.FragmentBookListBinding
import com.example.mygooglebook.remote.data.ImageLinksList
import com.example.mygooglebook.remote.data.Items
import com.example.mygooglebook.remote.data.VolumeInfoList
import org.koin.android.ext.android.inject

class ListFragment : Fragment(){

    private val viewmodel : ListViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentBookListBinding.inflate(inflater,container,false)
        val adapter = ListFragmentAdapter()
        binding.listRecyclerview.adapter  = adapter
        observeBookList(adapter)


        return binding.root
    }

    fun observeBookList(adapter : ListFragmentAdapter){
        viewmodel.bookList.observe(viewLifecycleOwner){
            Log.e("ListFragment","옵저브 성공")
        }
    }

}