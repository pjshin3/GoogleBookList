package com.example.mygooglebook.remote


import com.example.mygooglebook.remote.data.ResponseBookData
import io.reactivex.Single

interface Repository{
    fun getBookList(param:Map<String,String>) : Single<ResponseBookData>
}