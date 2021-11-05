package com.randhir.foodxme.model.product

import com.google.gson.annotations.SerializedName

data class ProductListImage (

    @SerializedName("id")
    val id: Int,

    @SerializedName("picture_id")
    val pictureId: Int,

    @SerializedName("position")
    val position: Int,

    @SerializedName("src")
    val src: String,

    @SerializedName("attachment")
    val attachment: String

)