package com.randhir.foodxme.model.categories

import com.google.gson.annotations.SerializedName

data class CategoriesListImage (

    @SerializedName("src")
    val src:String,

     @SerializedName("attachment")
    val attachment:String

)
