package com.example.examenparcial_diegoalonsoolivera_ws7c.controllers.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.examenparcial_diegoalonsoolivera_ws7c.R
import com.example.examenparcial_diegoalonsoolivera_ws7c.adapter.AlbumAdapter
import com.example.examenparcial_diegoalonsoolivera_ws7c.models.Album
import com.example.examenparcial_diegoalonsoolivera_ws7c.models.ApiResponseHeader
import com.example.examenparcial_diegoalonsoolivera_ws7c.network.AlbumService
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Detail : AppCompatActivity() {
    val albums = ArrayList<Album>()
    val albumDetail = AlbumAdapter(albums, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        initView()
    }

    private fun initView() {
        val teSearch = findViewById<TextInputEditText>(R.id.teSearch)
        val btSearch = findViewById<Button>(R.id.btSearch)
        val rvAlbums = findViewById<RecyclerView>(R.id.rvAlbums)

        btSearch.setOnClickListener {
            val albumId = teSearch.text.toString()

            loadAlbumById(albumId)
        }
    }

    private fun loadAlbumById(albumId: String) {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/albums/${albumId}")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val albumService: AlbumService
        albumService = retrofit.create(AlbumService::class.java)

        val request = albumService.getAlbumById()

        request.enqueue(object : Callback<ApiResponseHeader> {
            override fun onResponse(
                call: Call<ApiResponseHeader>,
                response: Response<ApiResponseHeader>
            ) {
                if (response.isSuccessful) {
                    albums.clear()
                    val newAlbum = Album(0, albumId, 0)
                    albums.add(newAlbum)
                }
                else {
                    Toast.makeText(this@Detail, "Solo hay id’s entre 1 y 100", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ApiResponseHeader>, t: Throwable) {
                Toast.makeText(this@Detail, "Solo hay id’s entre 1 y 100", Toast.LENGTH_SHORT).show()
            }

        })


    }
}