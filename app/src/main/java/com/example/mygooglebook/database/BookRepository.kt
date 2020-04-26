package com.example.mygooglebook.database

import androidx.lifecycle.LiveData
import io.reactivex.Observable

class BookRepository(private val bookDao: BookDao){
    fun getMyBookList(): LiveData<List<Book>> = bookDao.getBook()
    fun myBookInsert(book: Book) = bookDao.myBookInsert(book)
}