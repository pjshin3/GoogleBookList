package com.example.mygooglebook.gen

import arrow.core.Either
import com.example.mygooglebook.Seach.QueryViewState
import com.example.mygooglebook.remote.data.BookError
import io.kotlintest.properties.Gen
import com.example.mygooglebook.util.left
import com.example.mygooglebook.util.right
import io.kotlintest.properties.filterIsInstance


class SuggstionGenerator: Gen<Either<BookError,List<String>>>{
    override fun constants(): Iterable<Either<BookError, List<String>>> = emptyList()

    override fun random(): Sequence<Either<BookError, List<String>>> = generateSequence {
        genaerateEither(Gen.bool().random().first())
    }

    private fun genaerateEither(it: Boolean): Either<BookError,List<String>> {
        return if(it){
            left(Gen.bookError().random().first())
        }else{
            right((1..10).fold( emptyList()) { acc, _ ->
                acc + Gen.query().random().iterator().next() })
        }
    }
}

class BookErrorGenerator : Gen<BookError> {
    override fun constants(): Iterable<BookError> = emptyList()

    override fun random(): Sequence<BookError> = generateSequence {
        takeIf { Gen.bool().random().first() }
            ?.let { BookError.EmptyResultError } ?: BookError.NetworkError
    }
}

class QueryGenerator : Gen<String> {
    override fun constants(): Iterable<String> = Gen.string().constants().filter{ it.isNotEmpty() }

    override fun random(): Sequence<String> = Gen.string().random().filter { it.isNotEmpty() }
}

class SuggestionViewStateGenerator : Gen<QueryViewState<String>>{
    override fun constants(): Iterable<QueryViewState<String>> = listOf(
        QueryViewState.idel(),
        QueryViewState.loading()
    )

    override fun random(): Sequence<QueryViewState<String>> = Gen.suggestion().random().map { suggestion ->
        suggestion.fold(
            { QueryViewState.error<String>(it) },
            { QueryViewState.reulst(it) }
        )
    }

}


fun Gen.Companion.suggestion(): Gen<Either<BookError,List<String>>> = SuggstionGenerator()

fun Gen.Companion.bookError(): Gen<BookError> = BookErrorGenerator()

fun Gen.Companion.query(): Gen<String> = QueryGenerator()

fun Gen.Companion.suggestionViewState(): Gen<QueryViewState<String>> = SuggestionViewStateGenerator()

fun Gen.Companion.sugestionErrorViewState(): Gen<QueryViewState.Error> = suggestionViewState().filterIsInstance()