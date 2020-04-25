package com.example.mygooglebook.data


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Observable

@Dao
interface BookDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item : Book)
    @Query("SELECT * FROM book ORDER BY title")
    fun getBook(): Observable<Book>
}