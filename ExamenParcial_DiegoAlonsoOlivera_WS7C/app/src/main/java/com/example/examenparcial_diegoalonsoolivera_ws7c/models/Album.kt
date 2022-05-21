package com.example.examenparcial_diegoalonsoolivera_ws7c.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "albums")
class Album (
    @PrimaryKey
    @SerializedName("album_id")
    val albumId: Int = 0,

    @SerializedName("title")
    val title: String,

    @SerializedName("user_id")
    val userId: Int = 0
): Serializable