package com.example.mygooglebook.List

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.mygooglebook.remote.SeachBookRepository
import com.example.mygooglebook.remote.data.ResponseBookData

class ListViewModel(private val seachRepository : SeachBookRepository) : ViewModel(){
    val bookList : LiveData<ResponseBookData> = seachRepository.getbookList()
}