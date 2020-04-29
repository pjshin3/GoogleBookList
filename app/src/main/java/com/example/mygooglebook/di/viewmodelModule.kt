package com.example.mygooglebook.di

import com.example.mygooglebook.MyBookList.MyBookListViewModel
import com.example.mygooglebook.Seach.SeachViewModel
import com.example.mygooglebook.remote.*
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val viewmodelModule = module {
//    viewModel { SeachViewModel(get()) }
    factory { DataBaseSource(get()) }
    factory { RemoteDataSource(get()) }
    factory { SeachRepository(get(),get()) }
    factory { SeachViewModel(get()) }
    viewModel { MyBookListViewModel() }
}