package com.example.mygooglebook.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [Book::class],version = 1,exportSchema = false)
abstract class AppDataBase : RoomDatabase(){
    abstract fun bookDao(): BookDao

    companion object{
        @Volatile private var instance : AppDataBase? = null
        fun getInstance(context : Context) : AppDataBase{
            return instance ?: synchronized(this){
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): AppDataBase{
            return Room.databaseBuilder(context,AppDataBase::class.java,"Mydata")
                .addCallback(object : RoomDatabase.Callback(){
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                    }
                }).build()
        }
    }


}