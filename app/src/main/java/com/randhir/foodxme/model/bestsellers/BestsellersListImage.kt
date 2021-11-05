package com.randhir.foodxme.model.bestsellers

import com.google.gson.annotations.SerializedName

data class BestsellersListImage(

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
