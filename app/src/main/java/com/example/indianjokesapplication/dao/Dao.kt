package com.example.indianjokesapplication.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.indianjokesapplication.joke_api.JokeDataClassItem


@Dao
interface Dao {

    @Insert
    suspend fun insertIntoDatabase(table: Table)
//
//    @Query("SELECT * FROM jokeTable")
//    suspend fun getAllJokesFromDatabase() : List<JokeDataClassItem>



}