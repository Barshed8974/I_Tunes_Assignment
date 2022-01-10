package com.assignment.myapplication.Source.Local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "newsDataBase")
data class Music (
    @ColumnInfo(name = "author")
    var author:String,
    @ColumnInfo(name = "image")
    var image:String
        ){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int? = null
}

