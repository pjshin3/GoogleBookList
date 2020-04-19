package com.example.mygooglebook.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "book")
data class Book(
    @PrimaryKey @ColumnInfo(name = "id") val bookId : String,
    val title : String,
    val imageUrl : String,
    val description : String,
    val ahtor : String
){
    override fun toString() = title
}