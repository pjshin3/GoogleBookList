package com.example.mygooglebook.di

import androidx.room.Room
import com.example.mygooglebook.database.AppDataBase
import com.example.mygooglebook.remote.Repository
import com.example.mygooglebook.remote.SeachRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module

val apiModule = module {
    single { Room.databaseBuilder(androidContext(), AppDataBase::class.java, "database").build() }
//    single { SeachRepository(get(),get()) }
}