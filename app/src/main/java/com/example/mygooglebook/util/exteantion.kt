package com.example.mygooglebook.util

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import arrow.core.Either
import arrow.core.left
import arrow.core.right
import com.example.mygooglebook.remote.data.BookError
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.android.MainThreadDisposable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

fun <T>LifecycleOwner.observe(livedata: LiveData<T>, action: (t : T) -> Unit){
    livedata.observe(this, Observer { t -> action(t) })
}

operator fun CompositeDisposable.plus(disposable: Disposable) : CompositeDisposable = apply {
    add(disposable)
}

fun <T> LiveData<T>.toFlowable(): Flowable<T> =
        Flowable.create({ emiiter ->
            val observer = Observer<T>{
                it?.let {emiiter.onNext(it)}
            }
            observeForever(observer)

            emiiter.setCancellable {
                object : MainThreadDisposable(){
                    override fun onDispose() = removeObserver(observer)
                }
            }
        }, BackpressureStrategy.LATEST)

fun <T> LiveData<T>.toObserveble(): Observable<T> =
        Observable.create{ emitter ->
            val observer = Observer<T>{
                it?.let { emitter.onNext(it) }
            }
            observeForever(observer)

            emitter.setCancellable {
                object  : MainThreadDisposable(){
                    override fun onDispose() = removeObserver(observer)
                }
            }
        }

fun <A,B> left(a : A): Either<A,B> = a.left()
fun <A,B> right(b : B): Either<A,B> = b.right()


fun BookError.toHumanResponse(): String = when(this) {
    BookError.NetworkError -> "check your app network"
    BookError.EmptyResultError -> "search without suggestion"
}