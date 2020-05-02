package com.example.mygooglebook.remote

import com.example.mygooglebook.remote.data.Items
import com.example.mygooglebook.remote.data.ResponseBookData
import io.reactivex.Completable
import io.reactivex.Single

interface RemoteRepository<T>{
    fun getSuggetionList(item: String) : Single<List<T>>
    fun getBookList(item: String) :  Single<List<Items>>
}

interface DataBaseRspository<T>{
    fun insert(item: String, list: List<T>) : Completable
}