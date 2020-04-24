package com.example.mygooglebook.di

import com.example.mygooglebook.remote.Api
import com.example.mygooglebook.remote.ApiRemoteSource
import com.example.mygooglebook.remote.SeachBookRepository
import org.koin.dsl.module.module
import retrofit2.Retrofit

val apiModule = module {
    single(createOnStart = false) { get<Retrofit>().create(Api::class.java) }
    single { ApiRemoteSource(get()) }
    single { SeachBookRepository(get()) }
}