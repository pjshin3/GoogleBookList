package com.example.mygooglebook.Seach

import com.example.mygooglebook.remote.data.BookError
import com.example.mygooglebook.remote.data.ResponseBookData

sealed class QueryViewState<out T>{

    companion object{
        fun <T> reulst(result: ResponseBookData): QueryViewState<T> = Result(result)
        fun <T> idel(): QueryViewState<T> = Idel
        fun <T> loading(): QueryViewState<T> = Loading
        fun <T> error(error : BookError): QueryViewState<T> = Error(error)
    }

    object Idel : QueryViewState<Nothing>()
    object Loading : QueryViewState<Nothing>()
    data class Result<out T>(val _reuslt : ResponseBookData) :  QueryViewState<T>()
    data class Error(val _error: BookError) : QueryViewState<Nothing>()

}