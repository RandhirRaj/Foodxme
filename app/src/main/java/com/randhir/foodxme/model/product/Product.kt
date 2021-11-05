package com.randhir.foodxme.model.product

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.randhir.foodxme.model.categories.CategoriesList

data class Product(

    @SerializedName("message")
    @Expose
    val message:String,

    @SerializedName("product_category_mappings")
    @Expose
    val products:List<ProductList>?


)
