package com.example.mygooglebook.remote

import com.example.mygooglebook.remote.data.ResponseBookData
import io.reactivex.Observable


class SeachBookRepository (private val api : ApiRemoteSource) : Repository {

    override fun getBookList(param: Map<String, String>): Observable<ResponseBookData> {
        val resultObserverble = api.getBookList(param)
        return resultObserverble
    }
}