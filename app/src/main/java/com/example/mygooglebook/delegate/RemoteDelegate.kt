package com.example.mygooglebook.delegate

import com.example.mygooglebook.List.BookListAdapter
import com.example.mygooglebook.Seach.SeachViewModel

class RemoteDelegate(
    val seachviewmodel : SeachViewModel,
    val adapter : BookListAdapter
) {
    fun onWorldChange(new : String): Unit =
        with(seachviewmodel) { query.value = new }
}