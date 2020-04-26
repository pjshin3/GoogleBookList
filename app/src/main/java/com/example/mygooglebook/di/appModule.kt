package com.example.mygooglebook.di

import com.example.mygooglebook.database.AppDataBase
import com.example.mygooglebook.database.BookRepository
import com.example.mygooglebook.remote.Repository
import com.example.mygooglebook.remote.SeachBookRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.module

val apiModule = module {
    factory<Repository> { SeachBookRepository(get()) }
    single { AppDataBase.getInstance(androidApplication()).bookDao() }
    single { BookRepository(get()) }
}