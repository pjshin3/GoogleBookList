package com.example.mygooglebook.remote

import com.example.mygooglebook.remote.data.BookError
import com.example.mygooglebook.remote.data.Items
import com.example.mygooglebook.remote.data.ResponseBookData
import com.example.mygooglebook.util.left
import com.example.mygooglebook.util.right
import io.reactivex.Flowable

abstract class Repository<T> (
    private val api : RemoteRepository<T>,
    private val local : DataBaseRspository<T>
){
    fun searchSuggestion(item : String) =
        api.getSuggetionList(item)
            .map { right<BookError,List<T>>(it) }
            .onErrorReturn { left<BookError,List<T>>(BookError.NetworkError) }
            .map { it }

    fun searchBookList(item : String) =
        api.getBookList(item)
            .map { right<BookError,List<Items>>(it) }
            .onErrorReturn { left<BookError,List<Items>>(BookError.NetworkError) }
            .map { it }
}