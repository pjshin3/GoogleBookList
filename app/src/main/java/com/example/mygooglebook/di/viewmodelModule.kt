package com.example.mygooglebook.di

import com.example.mygooglebook.MyBookList.MyBookListViewModel
import com.example.mygooglebook.Seach.SearchViewModel
import com.example.mygooglebook.Seach.SuggestionViewModel
import com.example.mygooglebook.remote.*
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val viewmodelModule = module {
//    viewModel { SeachViewModel(get()) }
    factory { DataBaseSource(get()) }
    factory { RemoteDataSource(get()) }
    factory { SeachRepository(get(),get()) }
    factory { SuggestionViewModel(get(parameters = { it })) }
    factory { SearchViewModel(get(parameters = { it })) }
    viewModel { MyBookListViewModel() }
}