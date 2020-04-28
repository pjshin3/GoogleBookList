package com.example.mygooglebook.Seach

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mygooglebook.remote.data.ResponseBookData
import com.example.mygooglebook.util.plus
import com.example.mygooglebook.util.toFlowable
import io.reactivex.Flowable
import io.reactivex.disposables.CompositeDisposable
import org.reactivestreams.Publisher

open class QueryViewModel<T>(
    transform : (Flowable<String>) -> Publisher<QueryViewState<ResponseBookData>>
) : ViewModel() {

    val query = MutableLiveData<String>()
    private val disposables : CompositeDisposable = CompositeDisposable()
    init {
        disposables + query.toFlowable()
            .compose { transform(it) }
            .subscribe({
                Log.e("QeuryViewModel","값이 출력 $it")
            },{

            })
    }

    override fun onCleared() = disposables.clear()
}