package com.example.examenparcial_diegoalonsoolivera_ws7c.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.examenparcial_diegoalonsoolivera_ws7c.models.Album

@Dao
interface AlbumDAO {
    @Insert
    fun insertAlbum(vararg album: Album)

    @Query("SELECT * FROM albums ")
    fun getAllAlbums(): List<Album>

    @Delete
    fun deleteAlbum(vararg album: Album)
}