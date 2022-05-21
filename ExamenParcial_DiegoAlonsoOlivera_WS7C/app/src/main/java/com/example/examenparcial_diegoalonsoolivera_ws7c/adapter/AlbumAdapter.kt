package com.example.examenparcial_diegoalonsoolivera_ws7c.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.examenparcial_diegoalonsoolivera_ws7c.R
import com.example.examenparcial_diegoalonsoolivera_ws7c.models.Album
import kotlinx.android.synthetic.main.prototype_album.view.*

class AlbumAdapter(val albums: List<Album>, val context: Context): RecyclerView.Adapter<AlbumAdapter.ViewHolder>() {
    class ViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        val tvItemUserId = view.tvItemUserId
        val tvItemId = view.tvItemId
        val tvItemTitle = view.tvItemTitle
    }

    interface OnItemClickListener {
        fun onItemClicked(album: Album)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.prototype_album, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val album = albums[position]
        holder.tvItemUserId.text = album.userId.toString()
        holder.tvItemId.text = album.albumId.toString()
        holder.tvItemTitle.text = album.title

        holder.view.cvAlbum.setOnClickListener {
//            itemClickListener.onItemClicked(album)
        }
    }

    override fun getItemCount(): Int {
        return albums.size
    }
}