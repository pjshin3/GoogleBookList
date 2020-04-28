package com.example.mygooglebook.util

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.android.MainThreadDisposable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

fun <T>LifecycleOwner.observe(livedata: LiveData<T>, action: (t : T) -> Unit){
    livedata.observe(this, Observer { t -> action(t) })
}

operator fun CompositeDisposable.plus(disposable: Disposable) = CompositeDisposable().apply {
    add(disposable)
}

fun <T>LiveData<T>.toFlowable(): Flowable<T> =
    Flowable.create({emiiter ->
        val observer = Observer<T>{
            it?.let { emiiter::onNext }
        }
        observeForever(observer)

        emiiter.setCancellable {
            object : MainThreadDisposable(){
                override fun onDispose() = removeObserver(observer)
            }
        }
    }, BackpressureStrategy.LATEST)