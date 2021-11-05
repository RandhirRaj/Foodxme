package com.randhir.foodxme.ui.product

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.randhir.foodxme.R
import com.randhir.foodxme.model.categories.CategoriesList
import com.randhir.foodxme.model.product.ProductList
import com.randhir.foodxme.ui.dashboard.CategoriesAdapter
import kotlinx.android.synthetic.main.item_categories_list_view.view.*
import kotlinx.android.synthetic.main.item_categories_list_view.view.textViewCategoriesName
import kotlinx.android.synthetic.main.item_product_list_view.view.*

class ProductAdapter (val productList: List<ProductList>?) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    var positionClickLis:((String?)->Unit) ? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_product_list_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int {
        return productList?.size!!
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind() {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                with(itemView) {
                    Glide.with(itemView.context)
                        .load( productList?.get(position)?.image?.get(0)?.src)
                        .centerCrop()
                        .into(imageViewProductImgUrl)

                    textViewProductName.text = productList?.get(position)?.productName
                    textViewProductPrice.text = itemView.context.getString(R.string.product_price,productList?.get(position)?.productPrice)
                    textViewProductDetails.text = "product details i need from api"
                }

                itemView.setOnClickListener {
                    positionClickLis?.invoke(productList?.get(position)?.id) }

            }
        }
    }

    fun setClickLisner(positionClickLis: (String?) -> Unit){
        this.positionClickLis=positionClickLis
    }

}