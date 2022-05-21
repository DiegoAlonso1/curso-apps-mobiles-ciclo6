package com.example.examenparcial_diegoalonsoolivera_ws7c.controllers.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.examenparcial_diegoalonsoolivera_ws7c.R
import com.example.examenparcial_diegoalonsoolivera_ws7c.adapter.AlbumAdapter
import com.example.examenparcial_diegoalonsoolivera_ws7c.controllers.activities.Detail
import com.example.examenparcial_diegoalonsoolivera_ws7c.models.Album
import com.example.examenparcial_diegoalonsoolivera_ws7c.models.ApiResponseHeader
import com.example.examenparcial_diegoalonsoolivera_ws7c.network.AlbumService
import kotlinx.android.synthetic.main.activity_detail.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AlbumFragment : Fragment(), AlbumAdapter.OnItemClickListener {
    var album: List<Album> = ArrayList()
    lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_album, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = rvAlbums
        loadAlbums(view.context)
    }
    private fun loadAlbums(context: Context) {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/albums")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val albumService: AlbumService
        albumService = retrofit.create(AlbumService::class.java)

        val request = albumService.getAllAlbums()
        request.enqueue(object : Callback<ApiResponseHeader> {
            override fun onFailure(call: Call<ApiResponseHeader>, t: Throwable) {
                Log.d("Activity Fail", "Error :(")
            }
            override fun onResponse(call: Call<ApiResponseHeader>, responseDetails: Response<ApiResponseHeader>) {
                if (responseDetails.isSuccessful) {
                    val albums: List<Album> = responseDetails.body()!!.api.albums ?: ArrayList()
                    recyclerView.layoutManager = LinearLayoutManager(context)
//                    recyclerView.adapter = AlbumAdapter(albums, context, this@AlbumFragment)
                }

                else{
                    Log.d("Activity Fail", "Error: "+responseDetails.code())
                }
            }
        })
    }
    override fun onItemClicked(album: Album)
    {
        val intent = Intent(context, Detail::class.java)
        intent.putExtra("Album", album)
        startActivity(intent)
    }
}