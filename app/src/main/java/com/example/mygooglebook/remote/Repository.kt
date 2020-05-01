package com.example.mygooglebook.remote

import arrow.core.Either
import com.example.mygooglebook.remote.data.BookError
import com.example.mygooglebook.util.left
import com.example.mygooglebook.util.right
import io.reactivex.*

abstract class Repository<T> (
    private val api : RemoteRepository<T>,
    private val local : DataBaseRspository<T>
){
    fun find(item : String) =
        api.getBookList(item)
            .map { right<BookError,List<T>>(it) }
            .onErrorReturn { left<BookError,List<T>>(BookError.NetworkError) }
            .map { it }
}