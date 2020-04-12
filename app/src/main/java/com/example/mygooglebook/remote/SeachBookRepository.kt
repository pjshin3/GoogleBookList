package com.example.mygooglebook.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mygooglebook.remote.data.ResponseBookData

class SeachBookRepository (private val api : SeachBook) {

    private val _bookList : MutableLiveData<ResponseBookData> = MutableLiveData()
    val bookList : LiveData<ResponseBookData>
        get() = _bookList

    fun SeachingBookList (seachItem : Map<String,String>) {
        _bookList.value = api.seachBookApi(seachItem)
    }

    fun getbookList() = bookList

}