package com.randhir.foodxme.model.categories

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Categories (

    @SerializedName("categories")
    @Expose
    val category:List<CategoriesList>
)
