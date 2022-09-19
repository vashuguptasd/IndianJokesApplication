package com.example.indianjokesapplication.dao

class Repo (private val dao : Dao) {

    suspend fun insertIntoDatabase( table : Table) = dao.insertIntoDatabase(table)
}