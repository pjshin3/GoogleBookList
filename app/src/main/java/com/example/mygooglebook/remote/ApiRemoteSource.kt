package com.example.mygooglebook.remote

class ApiRemoteSource (val api : Api) {
    fun getBookList(param : Map<String,String>) = api.getBookList(param)
}