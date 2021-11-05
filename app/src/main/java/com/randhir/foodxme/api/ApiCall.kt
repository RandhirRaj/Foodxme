package com.randhir.foodxme.api

import com.randhir.foodxme.model.bestsellers.Bestsellers
import com.randhir.foodxme.model.categories.Categories
import com.randhir.foodxme.model.login.LoginDto
import com.randhir.foodxme.model.product.Product
import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.*

interface ApiCall {

//    @Headers("Content-Type:application/json")
//    @FormUrlEncoded
//    @POST("tocken")
//    fun getToken(
//        @Field("UserName") userName: String,
//        @Field("Password") password: String,
//        @Field("grant_type") grantType: String,
//    ): Call<TokenParser>

    @GET("api/login")
    fun getLoginData(@Query("username", encoded = true) username: String, @Query("password",encoded = true) password: String) :Call<LoginDto>

    @GET("api/categories")
    fun getCategoriesList(@Query("fields") mobile: String): Call<Categories>

    @GET("api/bestsellers")
    fun getBestsellersList(): Call<Bestsellers>

    @GET("api/Product_Category_Mappings")
    fun getProductsList(@Query("category_id") fields: String): Call<Product>

//    @GET("api/UpdateDeviceTocken")
//    fun updateDeviceTocken(
//        @Query("mobileno") mobile: String,
//        @Query("DeviceTocken") deviceTocken: String,
//    ): Call<UpdateDeviceTocken>
//
//    @GET("api/GatAvailableLeadsByPartnerId")
//    fun gatAvailableLeads(@Query("PartnerId") partnerId: String): Call<GatAvailableLeads>


}