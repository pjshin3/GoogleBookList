package com.example.mygooglebook.Seach

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mygooglebook.remote.SeachBookRepository
import com.example.mygooglebook.remote.data.ResponseBookData
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class SeachViewModel (private val seachRepository : SeachBookRepository) : ViewModel(){

    private val _result : MutableLiveData<ResponseBookData> = MutableLiveData()
    val result : LiveData<ResponseBookData>
        get() = _result

    fun seachBookStart(world : String){
        seachRepository.getBookList(genarateSerchParams(world))
            .observeOn(Schedulers.newThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                _result.postValue(it)
            },{
                throw it
            })
    }

    fun genarateSerchParams(world : String) : Map<String,String>{
        val param : MutableMap<String,String> = mutableMapOf()
        param.put("q",world)
        param.put("oderBy","newest")
        param.put("key","AIzaSyC1gWxwOTOlanFaEl4nGgSz6goRRhYKZbo")
        return param
    }
}