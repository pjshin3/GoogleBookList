package com.example.mygooglebook.Seach

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mygooglebook.util.plus
import com.example.mygooglebook.util.toFlowable
import io.reactivex.Flowable
import io.reactivex.disposables.CompositeDisposable
import org.reactivestreams.Publisher

open class QueryViewModel<T>(
    transform : (Flowable<String>) -> Publisher<QueryViewState<T>>
) : ViewModel() {

    private val _state: MutableLiveData<QueryViewState<T>> = MutableLiveData()
    val state : LiveData<QueryViewState<T>>
        get() = _state

    val query : MutableLiveData<String> = MutableLiveData()
    private val disposables : CompositeDisposable = CompositeDisposable()

    init {
        disposables + query.toFlowable()
            .compose { transform(it) }
            .subscribe{
                _state.postValue(it)
            }
    }

    override fun onCleared() : Unit = disposables.clear()
}