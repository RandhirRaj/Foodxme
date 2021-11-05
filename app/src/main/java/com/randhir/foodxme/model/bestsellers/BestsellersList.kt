package com.randhir.foodxme.model.bestsellers

import com.google.gson.annotations.SerializedName
import com.randhir.foodxme.model.categories.CategoriesListImage

data class BestsellersList (

    @SerializedName("name")
    val name:String,

    @SerializedName("price")
    val price:String,

    @SerializedName("old_price")
    val oldPrice:String,

    @SerializedName("images")
    val image: List<BestsellersListImage>,

    @SerializedName("id")
    val id:Int

)
