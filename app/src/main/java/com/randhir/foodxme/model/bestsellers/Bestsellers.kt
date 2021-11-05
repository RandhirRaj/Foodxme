package com.randhir.foodxme.model.bestsellers

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.randhir.foodxme.model.categories.CategoriesList
import java.io.Serializable

data class Bestsellers (

    @SerializedName("products")
    @Expose
    val products:List<BestsellersList>
): Serializable
