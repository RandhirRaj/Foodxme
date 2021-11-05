package com.randhir.foodxme.ui.gallery

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.randhir.foodxme.model.gallery.GalleryData
import kotlinx.android.synthetic.main.gallery_item_view.view.*
import java.util.*

class GalleryStaggeredViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val mRandom = Random()
    fun bindView(movieModel: GalleryData) {
        itemView.imageViewGallery.layoutParams.height = getRandomIntInRange(500, 300)
        Glide.with(itemView.context).load(movieModel.image).into(itemView.imageViewGallery)
    }

    private fun getRandomIntInRange(max: Int, min: Int): Int {
        return mRandom.nextInt(max - min + min) + min
    }

}