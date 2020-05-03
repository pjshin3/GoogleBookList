package com.example.mygooglebook.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(
    entities = [
        Book::class
    ], version = 1)
abstract class AppDataBase : RoomDatabase(){
    abstract fun bookDao(): BookDao
}