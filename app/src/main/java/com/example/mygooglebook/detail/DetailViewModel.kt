package com.example.mygooglebook.detail

import androidx.lifecycle.ViewModel


class DetailViewModel(
    val title : String,
    val imageUrl : String,
    val description: String
) : ViewModel() {
}