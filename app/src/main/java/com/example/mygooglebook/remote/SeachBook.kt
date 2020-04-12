package com.example.mygooglebook.remote

import androidx.lifecycle.LiveData
import com.example.mygooglebook.remote.data.ResponseBookData
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface SeachBook{

    @GET("books/v1/volumes/")
    fun seachBookApi(@QueryMap params : Map<String,String>) : ResponseBookData
}