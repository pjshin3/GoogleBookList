package com.example.mygooglebook.detail

import android.database.Observable
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mygooglebook.Seach.QueryViewState
import com.example.mygooglebook.database.Book
import com.example.mygooglebook.util.plus
import com.example.mygooglebook.util.toFlowable
import com.example.mygooglebook.util.toObserveble
import io.reactivex.Flowable
import io.reactivex.disposables.CompositeDisposable
import org.reactivestreams.Publisher

open class DetailSaveViewModel<T>(
    transform: (Flowable<Book>) -> Publisher<String>
): ViewModel() {

    private val _result = MutableLiveData<String>()
    val result: LiveData<String>
        get() = _result
    val book = MutableLiveData<Book>()

    private val disposable : CompositeDisposable = CompositeDisposable()

    init {
        disposable + book.toFlowable()
            .compose { transform(it) }
            .subscribe({
                Log.e("DetailSaveViewModel","성공 $it")
//                _result.postValue(it)
            },{
                Log.e("DetailSaveViewModel","실패 $it")
            })
    }
}