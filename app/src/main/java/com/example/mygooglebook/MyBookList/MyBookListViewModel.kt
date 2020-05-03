package com.example.mygooglebook.MyBookList

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.mygooglebook.database.Book
import com.example.mygooglebook.remote.ApiRepository

class MyBookListViewModel (
    private val api : ApiRepository
): ViewModel(){
    val result : LiveData<List<Book>>
        get() = api.getMyBookList()
}