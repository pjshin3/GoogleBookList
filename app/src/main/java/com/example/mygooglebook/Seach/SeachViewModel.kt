package com.example.mygooglebook.Seach

import androidx.lifecycle.ViewModel
import com.example.mygooglebook.remote.SeachBookRepository

class SeachViewModel (private val seachRepository : SeachBookRepository) : ViewModel(){

    fun seachBookStart(world : String){
        seachRepository.SeachingBookList(genarateSerchParams(world))
    }

    fun genarateSerchParams(world : String) : Map<String,String>{
        val param : MutableMap<String,String> = mutableMapOf()
        param.put("q",world)
        param.put("oderBy","newest")
        param.put("key","AIzaSyC1gWxwOTOlanFaEl4nGgSz6goRRhYKZbo")
        return param
    }
}