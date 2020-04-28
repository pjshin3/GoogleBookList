package com.example.mygooglebook.di

import androidx.room.Room
import com.example.mygooglebook.database.AppDataBase
import com.example.mygooglebook.database.BookRepository
import com.example.mygooglebook.remote.Repository
import com.example.mygooglebook.remote.SeachBookRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module

val apiModule = module {
    factory<Repository> { SeachBookRepository(get()) }
    single { Room.databaseBuilder(androidContext(), AppDataBase::class.java, "mybookdatabase").build() }
    single { BookRepository(get()) }
}