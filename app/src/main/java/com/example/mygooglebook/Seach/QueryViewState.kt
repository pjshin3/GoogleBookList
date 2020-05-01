package com.example.mygooglebook.Seach

import arrow.core.Either
import com.example.mygooglebook.remote.data.BookError

sealed class QueryViewState<out T>{

    companion object{
        fun <T> reulst(result: List<T>): QueryViewState<T> = Result(result)
        fun <T> idel(): QueryViewState<T> = Idel
        fun <T> loading(): QueryViewState<T> = Loading
        fun <T> error(error : BookError): QueryViewState<T> = Error(error)
    }

    object Idel : QueryViewState<Nothing>()
    object Loading : QueryViewState<Nothing>()
    data class Result<out T>(val _reuslt : List<T>) :  QueryViewState<T>()
    data class Error(val _error: BookError) : QueryViewState<Nothing>()

}

fun <T> Either<BookError, List<T>>.toViewState(): QueryViewState<T> = fold(
    { QueryViewState.error(it)},
    { QueryViewState.reulst(it) }
)