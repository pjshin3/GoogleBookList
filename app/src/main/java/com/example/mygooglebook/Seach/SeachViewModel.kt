package com.example.mygooglebook.Seach

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mygooglebook.remote.Repository
import com.example.mygooglebook.remote.data.ResponseBookData
import io.reactivex.schedulers.Schedulers

class SeachViewModel (private val seachRepository : Repository) : ViewModel(){

    private val _result = MutableLiveData<ResponseBookData>()
    val result : LiveData<ResponseBookData>
        get() = _result

    @SuppressLint("CheckResult")
    fun seachBookStart(world : String){
        seachRepository.getBookList(genarateSerchParams(world))
            .subscribeOn(Schedulers.io())
            .subscribe({
            _result.postValue(it)
        },{
            throw it
        })
    }

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