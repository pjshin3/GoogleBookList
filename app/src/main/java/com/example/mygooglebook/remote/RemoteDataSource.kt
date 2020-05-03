package com.example.mygooglebook.remote

import androidx.lifecycle.LiveData
import com.example.mygooglebook.database.AppDataBase
import com.example.mygooglebook.database.Book
import com.example.mygooglebook.remote.data.RemoteApi
import com.example.mygooglebook.remote.data.Items
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.internal.operators.completable.CompletableFromAction
import io.reactivex.schedulers.Schedulers

class RemoteDataSource (
    private val api : RemoteApi
) : RemoteRepository<String> {
    override fun getSuggetionList(item : String): Single<List<String>> =
        api.getBookList(genarateSerchParams(item))
            .subscribeOn(Schedulers.io())
            .map {
                it.items
                    .distinctBy { it.volumeInfo.title }
                    .map { it.volumeInfo.title }
            }

    override fun getBookList(item: String): Single<List<Items>> =
        api.getBookList(genarateSerchParams(item))
            .subscribeOn(Schedulers.io())
            .map { it.items }


    private fun genarateSerchParams(world : String) : Map<String,String> =
         mutableMapOf<String,String>(
            "q" to world,
            "oderBy" to "newest",
            "key" to "AIzaSyC1gWxwOTOlanFaEl4nGgSz6goRRhYKZbo"
        )
}

class DataBaseSource(
    private val appDataBase: AppDataBase
) : DataBaseRspository<String> {
    override fun insert(item: Book): Completable =
        Completable.fromAction {
            appDataBase.bookDao().myBookInsert(item)
        }.subscribeOn(Schedulers.single())

    override fun getMyBookList(): LiveData<List<Book>> =
        appDataBase.bookDao().getBook()
}