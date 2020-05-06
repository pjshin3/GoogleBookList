package com.example.mygooglebook.suggestion

import android.widget.SearchView
import com.arlib.floatingsearchview.FloatingSearchView
import com.example.mygooglebook.Seach.QueryViewState
import com.example.mygooglebook.bind.bindSuggestion
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import io.kotlintest.specs.StringSpec

class SuggestionBindingAdapterTest: StringSpec({
    "FloatingSearchView should show progress on loading state"{
        val view = mock<FloatingSearchView>()
        view.bindSuggestion(QueryViewState.loading())
        verify(view).showProgress()
    }
})