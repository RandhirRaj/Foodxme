package com.randhir.foodxme.model.product

import com.google.gson.annotations.SerializedName
import com.randhir.foodxme.model.bestsellers.BestsellersListImage
import com.randhir.foodxme.model.categories.CategoriesListImage

data class ProductList(


//    @SerializedName("name")
//    val name: String,

    @SerializedName("images")
    val image: List<ProductListImage>,

    @SerializedName("id")
    val id: String,
    @SerializedName("product_id")
    val productId: Int,
    @SerializedName("category_id")
    val categoryId: Int,
    @SerializedName("is_featured_product")
    val isFeaturedProduct: Boolean,
    @SerializedName("display_order")
    val displayOrder: Int,
    @SerializedName("product_name")
    val productName: String,
    @SerializedName("product_price")
    val productPrice: Double

    )
