package com.example.mygooglebook.di

import com.example.mygooglebook.data.AppDataBase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module

val databaseModule = module {
    single { AppDataBase.getInstance(androidContext()).bookDao() }
}

