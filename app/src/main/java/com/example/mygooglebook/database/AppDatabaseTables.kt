package com.example.mygooglebook.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "book")
data class Book(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val bookId : Long,
    val title : String,
    val imageUrl : String,
    val description : String,
    val ahtor : String
){
    override fun toString() = title
}

@Entity(tableName = "suggestion")
data class Suggestion(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val suggestionId: Long,
    val title : String,
    val queryId : String
)