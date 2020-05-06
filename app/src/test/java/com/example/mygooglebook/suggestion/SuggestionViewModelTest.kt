package com.example.mygooglebook.suggestion

import android.util.Log
import arrow.core.Either
import com.example.mygooglebook.Seach.QueryViewState
import com.example.mygooglebook.Seach.SuggestionViewModel
import com.example.mygooglebook.gen.suggestion
import com.example.mygooglebook.remote.data.BookError
import com.example.mygooglebook.util.toFlowable
import com.nhaarman.mockitokotlin2.mock
import io.kotlintest.properties.Gen
import io.kotlintest.properties.assertAll
import io.kotlintest.specs.StringSpec
import io.reactivex.Flowable
import org.mockito.ArgumentMatchers.anyString

class SuggestionViewModelTest :
    StringSpec({
        "Suggestion ViewModel should not trigger search for empty query" {
            assertAll(Gen.suggestion()) { suggestion ->

                val viewmodel = givenSuggestionViewModel(suggestion)
                val observer = viewmodel.state.toFlowable().test()

                viewmodel.inputQuery("adf")

                observer.assertNotComplete()
                    .assertNoErrors()
                    .assertValue(QueryViewState.idel())
            }
        }
    })


private fun SuggestionViewModel.inputQuery(input : String){
    query.value = input
}

private fun givenSuggestionViewModel(suggestion: Either<BookError,List<String>>): SuggestionViewModel =
    SuggestionViewModel.invoke(mock{
        on { searchSuggestion(anyString()).toFlowable() }.thenReturn(Flowable.just(suggestion))
    })