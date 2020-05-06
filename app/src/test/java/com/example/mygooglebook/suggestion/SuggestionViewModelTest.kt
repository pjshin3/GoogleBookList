package com.example.mygooglebook.suggestion

import arrow.core.Either
import com.example.mygooglebook.Seach.SuggestionViewModel
import com.example.mygooglebook.gen.suggestion
import com.example.mygooglebook.remote.data.BookError
import com.example.mygooglebook.util.toFlowable
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import io.kotlintest.properties.Gen
import io.kotlintest.properties.assertAll
import io.kotlintest.specs.StringSpec
import io.reactivex.Flowable

class SuggestionViewModelTest :
    StringSpec({
        "Suggestion ViewModel should not trigger search for empty query" {
            assertAll(Gen.suggestion()) { suggestion ->
                val viewmodel = givenSuggestionViewModel(suggestion)
                val observer = viewmodel.state.toFlowable().test()

                TODO("초기화한 뷰모델을 옵저브해서 값을 체크")

            }
        }
    })


private fun SuggestionViewModel.inputQuery(input : String){
    query.value = input
    TODO()
}

private fun givenSuggestionViewModel(suggestion: Either<BookError,List<String>>): SuggestionViewModel =
    SuggestionViewModel.invoke(mock{
        on { searchSuggestion(any()) }
    })