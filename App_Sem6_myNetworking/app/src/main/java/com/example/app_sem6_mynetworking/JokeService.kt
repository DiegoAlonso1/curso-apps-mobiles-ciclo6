package com.example.app_sem6_mynetworking

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface JokeService {
    @GET("api")
    fun getJoke(@Query("format") format: String) : Call<Joke>
}