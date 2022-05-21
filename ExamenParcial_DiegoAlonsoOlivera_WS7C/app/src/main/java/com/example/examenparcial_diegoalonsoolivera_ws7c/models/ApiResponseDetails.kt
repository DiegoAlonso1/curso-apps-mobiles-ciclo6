package com.example.examenparcial_diegoalonsoolivera_ws7c.models

import com.google.gson.annotations.SerializedName

class ApiResponseDetails (
    @SerializedName("results")
    val results: Int,

    @SerializedName("albums")
    val albums: List<Album>
)