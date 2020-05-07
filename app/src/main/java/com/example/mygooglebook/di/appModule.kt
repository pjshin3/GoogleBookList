package com.example.mygooglebook.di

import androidx.room.Room
import com.example.mygooglebook.database.AppDataBase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val apiModule = module {
    single { Room.databaseBuilder(androidContext(), AppDataBase::class.java, "database").build() }
}