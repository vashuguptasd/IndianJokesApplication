package com.example.indianjokesapplication.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Table::class] , version = 1)
abstract class MyDatabase : RoomDatabase() {

    abstract fun getDao() : Dao
    companion object{

        @Volatile
        private var INSTANCE : MyDatabase? = null

        fun getDatabase (context : Context) : MyDatabase{

            synchronized(this){
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context , MyDatabase::class.java ,"myDb").build()
                }
                return  INSTANCE!!
            }
        }
    }
}