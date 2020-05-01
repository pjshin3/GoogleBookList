package com.example.mygooglebook.Seach


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.mygooglebook.Home.BOOK_LIST_PAGE_INDEX
import com.example.mygooglebook.List.BookListAdapter
import com.example.mygooglebook.R
import com.example.mygooglebook.databinding.FragmentSearchBinding
import com.example.mygooglebook.delegate.RemoteDelegate
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
            it.delegate = RemoteDelegate(suggetionViewModel = suggestionViewModel,searchViewModel = searchViewModel, adapter = BookListAdapter())
        }

        return binding.root
    }

   private fun navigateToListPage(){
        requireActivity().findViewById<ViewPager2>(R.id.view_pager).currentItem =
            BOOK_LIST_PAGE_INDEX
    }

   private fun View.hideKeyboard() {
       val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
       imm.hideSoftInputFromWindow(windowToken, 0)
   }
}