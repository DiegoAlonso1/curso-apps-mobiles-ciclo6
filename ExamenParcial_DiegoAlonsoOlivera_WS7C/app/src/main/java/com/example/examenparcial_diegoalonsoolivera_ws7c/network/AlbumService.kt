package com.example.examenparcial_diegoalonsoolivera_ws7c.network

import com.example.examenparcial_diegoalonsoolivera_ws7c.models.ApiResponseHeader
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface AlbumService {
    @GET()
    fun getAllAlbums(): Call<ApiResponseHeader>

    @GET()
    fun getAlbumById(): Call<ApiResponseHeader>
}