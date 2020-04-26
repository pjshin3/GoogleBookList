package com.example.mygooglebook.database


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Observable

@Dao
interface BookDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun myBookInsert(item : Book)
    @Query("SELECT * FROM book ORDER BY title")
    fun getBook(): LiveData<List<Book>>
}