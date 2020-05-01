package com.example.mygooglebook.delegate

import com.example.mygooglebook.List.BookListAdapter
import com.example.mygooglebook.Seach.SearchViewModel
import com.example.mygooglebook.Seach.SuggestionViewModel

class RemoteDelegate(
    val suggetionViewModel : SuggestionViewModel,
    val searchViewModel : SearchViewModel,
    val adapter : BookListAdapter
    ) {
    fun onWorldChange(new : String): Unit =
        with(suggetionViewModel) {query.value = new}
    fun onBookList(suggetion : String ): Unit =
        with(searchViewModel) {query.value = suggetion}
}