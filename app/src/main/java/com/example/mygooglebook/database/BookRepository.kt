package com.example.mygooglebook.database

import androidx.lifecycle.LiveData
import io.reactivex.Completable
import io.reactivex.schedulers.Schedulers

class BookRepository(private val appDataBase: AppDataBase){
    fun getMyBookList(): LiveData<List<Book>> = appDataBase.bookDao().getBook()
    fun myBookInsert(book: Book) = appDataBase.bookDao().myBookInsert(book)
    fun suggestionInsert(query : String, suggestion: List<String>) : Completable =
        Completable.fromAction{
            appDataBase.suggestionDao().InsertSuggestion(query,suggestion)
        }.subscribeOn(Schedulers.single())

}