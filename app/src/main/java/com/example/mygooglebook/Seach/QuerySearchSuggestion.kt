package com.example.mygooglebook.Seach

import com.arlib.floatingsearchview.suggestions.model.SearchSuggestion
import kotlinx.android.parcel.Parcelize

sealed class QuerySearchSuggestion (
    private val item : String
): SearchSuggestion{
    override fun getBody(): String  = item

    @Parcelize
    data class ResultSuggestion(val title : String) : QuerySearchSuggestion(title)

    @Parcelize
    data class ErrorSuggestion(val error : String) : QuerySearchSuggestion(error)
}