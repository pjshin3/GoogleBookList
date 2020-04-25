package com.example.mygooglebook.remote

import com.example.mygooglebook.remote.data.ApiRemoteSource
import com.example.mygooglebook.remote.data.ResponseBookData
import io.reactivex.Observable
import io.reactivex.Single


class SeachBookRepository (private val api : ApiRemoteSource) : Repository {

    override fun getBookList(param: Map<String, String>): Single<ResponseBookData> = api.getBookList(param)

}