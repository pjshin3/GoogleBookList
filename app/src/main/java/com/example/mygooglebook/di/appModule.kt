package com.example.mygooglebook.di

import com.bumptech.glide.util.pool.FactoryPools
import com.example.mygooglebook.remote.Repository
import com.example.mygooglebook.remote.data.Api
import com.example.mygooglebook.remote.data.ApiRemoteSource
import com.example.mygooglebook.remote.SeachBookRepository
import org.koin.dsl.module.module
import retrofit2.Retrofit

val apiModule = module {
    factory<Repository> { SeachBookRepository(get()) }
}