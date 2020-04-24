package com.example.mygooglebook.remote


import com.example.mygooglebook.remote.data.ResponseBookData
import io.reactivex.Observable

interface Repository{
    fun getBookList(param:Map<String,String>) : Observable<ResponseBookData>
}