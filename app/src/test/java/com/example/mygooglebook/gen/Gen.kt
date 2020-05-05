package com.example.mygooglebook.gen

import arrow.core.Either
import arrow.core.left
import com.example.mygooglebook.remote.data.BookError
import io.kotlintest.properties.Gen


class SuggstionGenerator: Gen<Either<BookError,List<String>>>{
    override fun constants(): Iterable<Either<BookError, List<String>>> = emptyList()

    override fun random(): Sequence<Either<BookError, List<String>>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun genaerateEither(it: Boolean): Either<BookError,List<String>> {
        TODO("")
    }
}


fun Gen.Companion.suggestion(): Gen<Either<BookError,List<String>>> = SuggstionGenerator()