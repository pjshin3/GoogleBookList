package com.example.mygooglebook.remote

import io.reactivex.Completable
import io.reactivex.Single

interface RemoteRepository<T>{
    fun getBookList(item: String) : Single<List<T>>
}

interface DataBaseRspository<T>{
    fun insert(item: String, list: List<T>) : Completable
}