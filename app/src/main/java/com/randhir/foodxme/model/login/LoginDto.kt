package com.randhir.foodxme.model.login

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LoginDto(

    @SerializedName("result")
    @Expose
    val result: String?,

    @SerializedName("customer")
    @Expose
    val customer: Customer?
)
