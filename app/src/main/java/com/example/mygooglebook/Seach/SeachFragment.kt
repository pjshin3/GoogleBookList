package com.example.mygooglebook.Seach

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mygooglebook.List.BookListAdapter
import com.example.mygooglebook.databinding.FragmentSearchBinding
import com.example.mygooglebook.delegate.SearchDelegate
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class SeachFragment : Fragment(){

    private val suggestionViewModel  by viewModel<SuggestionViewModel> { parametersOf(this.context!!.applicationContext) }
    private val searchViewModel  by viewModel<SearchViewModel> { parametersOf(this.context!!.applicationContext) }
    private lateinit var binding : FragmentSearchBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSearchBinding.inflate(inflater,container,false).also {
            it.setLifecycleOwner(this)
            it.delegate = SearchDelegate(suggetionViewModel = suggestionViewModel,searchViewModel = searchViewModel, adapter = BookListAdapter())
        }

        return binding.root
    }
}