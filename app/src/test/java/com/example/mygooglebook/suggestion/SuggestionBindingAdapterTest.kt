package com.example.mygooglebook.suggestion

import com.arlib.floatingsearchview.FloatingSearchView
import com.arlib.floatingsearchview.suggestions.model.SearchSuggestion
import com.example.mygooglebook.Seach.QueryViewState
import com.example.mygooglebook.bind.bindSuggestion
import com.example.mygooglebook.gen.sugestionErrorViewState
import com.example.mygooglebook.util.toHumanResponse
import com.nhaarman.mockitokotlin2.*
import io.kotlintest.properties.Gen
import io.kotlintest.properties.assertAll
import io.kotlintest.specs.StringSpec
import org.junit.jupiter.api.Assertions.assertEquals

class SuggestionBindingAdapterTest: StringSpec({
    "FloatingSearchView should show progress on loading state"{
        val view = mock<FloatingSearchView>()
        view.bindSuggestion(QueryViewState.loading())
        verify(view).showProgress()
    }

    "FloatingSearchVew should hide progress on idel state"{
        val view = mock<FloatingSearchView>()
        view.bindSuggestion(QueryViewState.idel())
        verify(view).hideProgress()
    }

    "FloatingSearchView should not have interaction on null state"{

        val view = mock<FloatingSearchView>()

        view.bindSuggestion(null)

        verifyZeroInteractions(view)
    }

    "FloatingSearchView should show human description on error state"{
        assertAll(Gen.sugestionErrorViewState()){ state ->
            val captor = argumentCaptor<List<SearchSuggestion>>()
            val searchView = mock<FloatingSearchView> {
                doNothing().whenever(it).swapSuggestions(captor.capture())
            }

            searchView.bindSuggestion(state)

            verify(searchView).swapSuggestions(any())
            with(captor.firstValue){
                assertEquals(1,size)
                assertEquals(state._error.toHumanResponse(), get(0).body)
            }
        }
    }
})