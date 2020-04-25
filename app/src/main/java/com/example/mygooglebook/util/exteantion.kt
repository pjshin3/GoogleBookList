package com.example.mygooglebook.util

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

fun <T>LifecycleOwner.observe(livedata: LiveData<T>, action: (t : T) -> Unit){
    livedata.observe(this, Observer { t -> action(t) })
}
