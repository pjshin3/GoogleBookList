package com.example.mygooglebook.remote

import androidx.lifecycle.LiveData
import com.example.mygooglebook.database.Book
import com.example.mygooglebook.remote.data.Items
import io.reactivex.Completable
import io.reactivex.Single

interface RemoteRepository<T>{
    fun getSuggetionList(item: String) : Single<List<T>>
    fun getBookList(item: String) :  Single<List<Items>>
}

interface DataBaseRspository<T>{
    fun insert(item: Book) : Completable
    fun getMyBookList(): LiveData<List<Book>>
}