package com.example.mygooglebook.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mygooglebook.remote.data.ResponseBookData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class SeachBookRepository (private val api : SeachBook) {
    private val disposables: CompositeDisposable = CompositeDisposable()
    private val _reulst : MutableLiveData<ResponseBookData> = MutableLiveData()
    val result : LiveData<ResponseBookData>
        get() = _reulst

    fun SeachingBookList (seachItem : Map<String,String>) {
        disposables.add(api.seachBookApi(seachItem)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.e("SeachBookRepository","셀프링크 = ${it}")
                _reulst.value = it
            },{

            }))
    }

}