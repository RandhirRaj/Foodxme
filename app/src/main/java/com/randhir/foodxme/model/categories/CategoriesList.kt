package com.randhir.foodxme.model.categories

import com.google.gson.annotations.SerializedName

data class CategoriesList (

    @SerializedName("name")
    val name:String,

    @SerializedName("image")
    val image:CategoriesListImage,

    @SerializedName("id")
    val id:String

)
