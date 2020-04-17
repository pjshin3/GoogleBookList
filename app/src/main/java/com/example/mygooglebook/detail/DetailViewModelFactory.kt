package com.example.mygooglebook.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class DetailViewModelFactory (
    private val title : String,
    private val imageUrl : String,
    private val description : String
): ViewModelProvider.NewInstanceFactory(){
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DetailViewModel(title = title,imageUrl = imageUrl,description = description) as T
    }
}