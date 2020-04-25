package com.example.mygooglebook.remote.data

class ApiRemoteSource (private val api : Api){
    fun getBookList(param : Map<String,String>) = api.getBookList(param)
}