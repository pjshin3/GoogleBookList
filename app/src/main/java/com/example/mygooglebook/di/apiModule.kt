package com.example.mygooglebook.di

import com.example.mygooglebook.remote.SeachBook
import com.example.mygooglebook.remote.SeachBookRepository
import org.koin.dsl.module.module
import retrofit2.Retrofit

val apiModule = module {
    single(createOnStart = false) { get<Retrofit>().create(SeachBook::class.java) }
    single { SeachBookRepository(get()) }
}