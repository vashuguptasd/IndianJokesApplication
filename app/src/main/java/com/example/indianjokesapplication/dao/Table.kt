package com.example.indianjokesapplication.dao

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "jokeTable")
data class Table(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    val text: String)

