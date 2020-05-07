package com.example.mygooglebook.di

import com.example.mygooglebook.MyBookList.MyBookListViewModel
import com.example.mygooglebook.Seach.SearchViewModel
import com.example.mygooglebook.Seach.SuggestionViewModel
import com.example.mygooglebook.detail.DetailViewModel
import com.example.mygooglebook.remote.*
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewmodelModule = module {

    factory { DataBaseSource(get()) }
    factory { RemoteDataSource(get()) }
    factory { ApiRepository(get(),get()) }
    factory { SuggestionViewModel(get(parameters = { it })) }
    factory { SearchViewModel(get(parameters = { it })) }

    factory { DetailViewModel(get(parameters = { it })) }

    viewModel { MyBookListViewModel(get()) }
}