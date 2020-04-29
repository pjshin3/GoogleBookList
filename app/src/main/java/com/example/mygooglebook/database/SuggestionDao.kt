package com.example.mygooglebook.database

import androidx.room.*
import io.reactivex.Flowable

@Dao
abstract class SuggestionDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun InsertSuggestion(query: String ,list : List<String>) {
        list.map { Suggestion(queryId = query,title = it,suggestionId = 0) }
    }
//    @Query("SELECT * FROM suggestion WHERE title like :query")
//    fun getSuggestionList(query: String) : Flowable<List<Suggestion>>
}