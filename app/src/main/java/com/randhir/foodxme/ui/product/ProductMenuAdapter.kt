package com.randhir.foodxme.ui.product

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.randhir.foodxme.R
import com.randhir.foodxme.model.product.ProductMenu
import kotlinx.android.synthetic.main.item_product_menu_list_view.view.*

class ProductMenuAdapter(val productMenuList: List<ProductMenu>) :
    RecyclerView.Adapter<ProductMenuAdapter.ViewHolder>() {
    var selectedItemIndex = -1

    var positionClickLis: ((String?) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_product_menu_list_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int {
        return productMenuList.size
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind() {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
//                Log.e("image url", BuildConfig.IMAGE_URL + list[position].CatImgUrl?.drop(1))
                with(itemView) {

                    if (productMenuList.get(position).isSelected) {
                        textViewProductMenuName.setTextColor(Color.parseColor("#000000"))
                    } else {
                        textViewProductMenuName.setTextColor(Color.parseColor("#ABABAB"))
                    }

                    itemView.setOnClickListener {
//                        clickListener.onItemClick(productMenuList.get(position), position)
                        productMenuList.get(position).isSelected = true
                        if (selectedItemIndex != -1){
                            productMenuList.get(position).isSelected = false
                        }
                        selectedItemIndex = position
                        notifyDataSetChanged()
                    }

                    textViewProductMenuName.text = productMenuList.get(position).neme
//                   temView.setOnClickListener {
//                        categoryClickListen?.invoke(list[position])
//                    }
                    //viewDivider.visibility = View.VISIBLE
//                    itemView.setOnClickListener {positionClickLis?.invoke(list[position].InqueryId) }

                }

//                itemView.setOnClickListener {positionClickLis?.invoke(categoriesList?.get(position)?.id) }

            }
        }
    }

    fun setClickLisner(positionClickLis: (String?) -> Unit) {
        this.positionClickLis = positionClickLis
    }

}