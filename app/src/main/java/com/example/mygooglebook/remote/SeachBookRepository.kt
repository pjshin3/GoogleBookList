package com.example.mygooglebook.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mygooglebook.remote.data.ResponseBookData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class SeachBookRepository (private val api : SeachBook) {
    private val disposables: CompositeDisposable = CompositeDisposable()
    private val _bookList : MutableLiveData<List<ResponseBookData>> = MutableLiveData()
    val bookList : LiveData<List<ResponseBookData>>
        get() = _bookList

    fun SeachingBookList (seachItem : Map<String,String>) = runBlocking {
        withContext(Dispatchers.IO){
            disposables.add(api.seachBookApi(params = seachItem)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError{Log.e("AAAA","")}
                .subscribe({
                    _bookList.value = it
                },{
                    Log.e("AAAA","$it")
                }))
            //TODO
            // 네트워크 모듈 개발해야됨.
        }
    }

    fun getbookList() = bookList

}