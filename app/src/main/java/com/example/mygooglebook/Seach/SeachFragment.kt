package com.example.mygooglebook.Seach

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mygooglebook.BaseFragment
import com.example.mygooglebook.List.BookListAdapter
import com.example.mygooglebook.R
import com.example.mygooglebook.databinding.FragmentSearchBinding
import com.example.mygooglebook.delegate.SearchDelegate
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class SeachFragment
    : BaseFragment<FragmentSearchBinding>(R.layout.fragment_search){

    private val suggestionViewModel  by viewModel<SuggestionViewModel> { parametersOf(this.context!!.applicationContext) }
    private val searchViewModel  by viewModel<SearchViewModel> { parametersOf(this.context!!.applicationContext) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(bindig){
            delegate = SearchDelegate(suggetionViewModel = suggestionViewModel,searchViewModel = searchViewModel, adapter = BookListAdapter())
        }
    }
}