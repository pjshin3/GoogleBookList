package com.example.mygooglebook.database

import androidx.lifecycle.LiveData
import io.reactivex.Observable

class BookRepository(private val appDataBase: AppDataBase){
    fun getMyBookList(): LiveData<List<Book>> = appDataBase.bookDao().getBook()
    fun myBookInsert(book: Book) = appDataBase.bookDao().myBookInsert(book)
}