package com.example.mygooglebook.remote

import com.example.mygooglebook.remote.data.ResponseBookData
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface Api{
    @GET("books/v1/volumes/")
    fun getBookList(@QueryMap params : Map<String,String>) : Observable<ResponseBookData>
}