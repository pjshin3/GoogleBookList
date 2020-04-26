package com.example.mygooglebook.MyBookList

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mygooglebook.database.Book
import com.example.mygooglebook.database.BookRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyBookListViewModel (private val bookRepository : BookRepository) : ViewModel(){
    val result : LiveData<List<Book>>
        get() = bookRepository.getMyBookList()

    fun inset(item : Book){
        viewModelScope.launch(Dispatchers.Default) {
            bookRepository.myBookInsert(book = item)
        }
    }
}