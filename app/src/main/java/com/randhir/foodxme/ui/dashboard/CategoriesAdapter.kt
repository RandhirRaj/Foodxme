package com.randhir.foodxme.ui.dashboard

import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.randhir.foodxme.R
import com.randhir.foodxme.model.categories.CategoriesList
import kotlinx.android.synthetic.main.item_categories_list_view.view.*

class CategoriesAdapter(val categoriesList: List<CategoriesList>) :
    RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {

    var positionClickLis:((String?)->Unit) ? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_categories_list_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CategoriesAdapter.ViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int {
        return categoriesList?.size!!
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind() {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
//                Log.e("image url", BuildConfig.IMAGE_URL + list[position].CatImgUrl?.drop(1))
                with(itemView) {
                    Glide.with(itemView.context)
                        .load( categoriesList?.get(position)?.image?.src)
                        .centerCrop()
                        .into(imageViewCategories)
                    textViewCategoriesName.text = categoriesList?.get(position)?.name
//                   temView.setOnClickListener {
//                        categoryClickListen?.invoke(list[position])
//                    }
                    //viewDivider.visibility = View.VISIBLE
//                    itemView.setOnClickListener {positionClickLis?.invoke(list[position].InqueryId) }

                }

                itemView.setOnClickListener {positionClickLis?.invoke(categoriesList?.get(position)?.id) }

            }
        }
    }

    fun setClickLisner(positionClickLis: (String?) -> Unit){
        this.positionClickLis=positionClickLis
    }

}