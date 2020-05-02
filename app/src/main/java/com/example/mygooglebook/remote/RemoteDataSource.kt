package com.example.mygooglebook.remote

import com.example.mygooglebook.database.AppDataBase
import com.example.mygooglebook.remote.data.Api
import com.example.mygooglebook.remote.data.Items
import com.example.mygooglebook.remote.data.ResponseBookData
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.internal.operators.completable.CompletableFromAction
import io.reactivex.schedulers.Schedulers

class RemoteDataSource (
    private val api : Api
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


    private fun genarateSerchParams(world : String) : Map<String,String>{
        val param = mutableMapOf<String,String>()
        with(param){
            put("q",world)
            put("oderBy","newest")
            put("key","AIzaSyC1gWxwOTOlanFaEl4nGgSz6goRRhYKZbo")
        }
        return param
    }
}

class DataBaseSource(
    private val appDataBase: AppDataBase
) : DataBaseRspository<String> {
    override fun insert(item: String, list: List<String>) : Completable =
        CompletableFromAction{
            appDataBase.suggestionDao().InsertSuggestion(item,list)
        }.subscribeOn(Schedulers.single())
}