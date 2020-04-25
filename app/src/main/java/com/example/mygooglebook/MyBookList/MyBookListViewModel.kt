package com.example.mygooglebook.MyBookList

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mygooglebook.data.AppDataBase
import com.example.mygooglebook.data.Book
import com.example.mygooglebook.data.BookDao
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MyBookListViewModel (private val bookDao: BookDao) : ViewModel(){
    private val _result = MutableLiveData<Book>()
    val result : LiveData<Book>
        get() = _result

    @SuppressLint("CheckResult")
    fun getMyBookList (){
        bookDao.getBook()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.e("MyBookListViewModel","데이터베이스 가져오기 성공")
            },{
                throw it
            })
    }
}