package com.randhir.foodxme.ui.home.toppick

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.randhir.foodxme.R
import com.randhir.foodxme.model.bestsellers.BestsellersList
import com.randhir.foodxme.model.categories.CategoriesList
import com.randhir.foodxme.ui.dashboard.CategoriesAdapter
import kotlinx.android.synthetic.main.item_categories_list_view.view.*
import kotlinx.android.synthetic.main.item_categories_list_view.view.imageViewCategories
import kotlinx.android.synthetic.main.item_home_top_pick_list_view.view.*

class HomeTopPickAdapter (val bestsellersList: List<BestsellersList>?) :
    RecyclerView.Adapter<HomeTopPickAdapter.ViewHolder>() {

    var positionClickLis:((String?)->Unit) ? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_home_top_pick_list_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int {
        return bestsellersList?.size!!
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind() {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
//                Log.e("image url", BuildConfig.IMAGE_URL + list[position].CatImgUrl?.drop(1))
                with(itemView) {
                    Glide.with(itemView.context)
                        .load( bestsellersList?.get(position)?.image?.get(0)?.src)
                        .centerCrop()
                        .into(imageViewProdeuct)
                    textViewMainCourseItem.text = bestsellersList?.get(position)?.name
                    textViewMainCourseItemName.text = bestsellersList?.get(position)?.name
                    textViewMainCourseItemDetaild.text = bestsellersList?.get(position)?.name

                    imageViewProdeuct.bringToFront()
//                   itemView.setOnClickListener {
//                        categoryClickListen?.invoke(list[position])
//                    }
                    //viewDivider.visibility = View.VISIBLE
//                    itemView.setOnClickListener {positionClickLis?.invoke(list[position].InqueryId) }

                    itemView.setOnClickListener {
                        positionClickLis?.invoke(bestsellersList?.get(position)?.id.toString()) }

                }
            }
        }
    }

    fun setClickLisner(positionClickLis: (String?) -> Unit){
        this.positionClickLis=positionClickLis
    }

}