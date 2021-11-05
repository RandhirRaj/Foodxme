package com.randhir.foodxme.ui.gallery

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.randhir.foodxme.R
import com.randhir.foodxme.model.gallery.GalleryData

class GalleryStaggeredAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var listOfMovies = listOf<GalleryData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return GalleryStaggeredViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.gallery_item_view, parent, false))
    }

    override fun getItemCount(): Int = listOfMovies.size

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        val galleryViewHolder = viewHolder as GalleryStaggeredViewHolder
        galleryViewHolder.bindView(listOfMovies[position])
    }

    fun setMovieList(listOfMovies: List<GalleryData>) {
        this.listOfMovies = listOfMovies
        notifyDataSetChanged()
    }
}