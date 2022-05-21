package com.example.examenparcial_diegoalonsoolivera_ws7c.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.examenparcial_diegoalonsoolivera_ws7c.models.Album

@Database(entities = [Album::class], version = 1)
abstract class AlbumDB : RoomDatabase() {
    abstract fun getAlbumDao(): AlbumDAO

    companion object{

        private var INSTANCE: AlbumDB? = null

        fun getInstance(context: Context): AlbumDB {
            if (INSTANCE == null){
                INSTANCE = Room
                    .databaseBuilder(context, AlbumDB::class.java, "myalbums.db")
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE as AlbumDB
        }
    }
}