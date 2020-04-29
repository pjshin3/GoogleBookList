package com.example.mygooglebook.Seach

import arrow.core.Option
import arrow.core.toOption
import com.example.mygooglebook.remote.data.BookError

val <T>QueryViewState<T>.error: Option<BookError>
    get() = when(this){
        is QueryViewState.Error -> _error.toOption()
        else -> Option.empty()
    }
val <T>QueryViewState<T>.Loading: Boolean
    get() = when(this){
        is QueryViewState.Loading -> true
        else -> false
    }
val <T>QueryViewState<T>.Result : List<T>
    get() = when(this){
        is QueryViewState.Result -> _reuslt
        else -> emptyList()
    }