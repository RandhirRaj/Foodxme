package com.randhir.foodxme.api

import android.content.Context
import com.randhir.foodxme.BuildConfig
import com.randhir.foodxme.R
import com.randhir.foodxme.isOnline
import com.randhir.foodxme.model.bestsellers.Bestsellers
import com.randhir.foodxme.model.categories.Categories
import com.randhir.foodxme.model.login.LoginDto
import com.randhir.foodxme.model.product.Product
import com.randhir.foodxme.token
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit

class ApiHandler(private val context: Context) {

    private var categories: Call<Categories>? = null
    private var bestsellers: Call<Bestsellers>? = null
    private var product: Call<Product>? = null
    private var loginDto: Call<LoginDto>? = null

    private var retrofitWithAuthorization = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(
            OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .addInterceptor(object : Interceptor {
                    @Throws(IOException::class)
                    override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
                        val newRequest: Request = chain.request().newBuilder()
                            .addHeader("Authorization", "Bearer ${token}")
//                            .addHeader("Content-Type","application/json")
                            .build()
                        return chain.proceed(newRequest)
                    }
                })
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .build()
        ).build()

    fun categoriesList(
        partnerId: String,
        error: (String?) -> Unit,
        success: (Categories?) -> Unit,
    ) {

        if (!context.isOnline()) {
            error.invoke(context.getString(R.string.no_internet))
        } else {
            categories =
                retrofitWithAuthorization.create(ApiCall::class.java).getCategoriesList(partnerId)
            categories?.enqueue(object : Callback<Categories> {

                override fun onResponse(
                    call: Call<Categories>,
                    response: Response<Categories>,
                ) {
                    success.invoke(response.body())
                }

                override fun onFailure(call: Call<Categories>, t: Throwable) {
                    error.invoke(context.getString(R.string.error_msg))
                }

            })
        }
    }

    fun bestsSellersList(
        error: (String?) -> Unit,
        success: (Bestsellers?) -> Unit,
    ) {

        if (!context.isOnline()) {
            error.invoke(context.getString(R.string.no_internet))
        } else {
            bestsellers = retrofitWithAuthorization.create(ApiCall::class.java).getBestsellersList()
            bestsellers?.enqueue(object : Callback<Bestsellers> {

                override fun onResponse(
                    call: Call<Bestsellers>,
                    response: Response<Bestsellers>,
                ) {
                    success.invoke(response.body())
                }

                override fun onFailure(call: Call<Bestsellers>, t: Throwable) {
                    error.invoke(context.getString(R.string.error_msg))
                }

            })
        }
    }



    fun productsList(
        partnerId: String,
        error: (String?) -> Unit,
        success: (Product?) -> Unit,
    ) {
        if (!context.isOnline()) {
            error.invoke(context.getString(R.string.no_internet))
        } else {
            product =
                retrofitWithAuthorization.create(ApiCall::class.java).getProductsList(partnerId)
            product?.enqueue(object : Callback<Product> {

                override fun onResponse(
                    call: Call<Product>,
                    response: Response<Product>,
                ) {
                    if (response.code()==200)
                    success.invoke(response.body())
                    else
                    error.invoke(response.errorBody()?.string())
                }

                override fun onFailure(call: Call<Product>, t: Throwable) {
                    error.invoke(context.getString(R.string.error_msg))
                }

            })
        }
    }


    fun login(
        emailOrPhone: String,
        password: String,
        error: (String?) -> Unit,
        success: (LoginDto?) -> Unit,
    ) {
        if (!context.isOnline()) {
            error.invoke(context.getString(R.string.no_internet))
        } else {
            loginDto =
                retrofitWithAuthorization.create(ApiCall::class.java).getLoginData("softwaretech100@gmail.com","Admin123%23")
            loginDto?.enqueue(object : Callback<LoginDto> {

                override fun onResponse(
                    call: Call<LoginDto>,
                    response: Response<LoginDto>,
                ) {
                    if (response.code()==200)
                    success.invoke(response.body())
                    else
                    error.invoke(response.errorBody()?.string())
                }

                override fun onFailure(call: Call<LoginDto>, t: Throwable) {
                    error.invoke(context.getString(R.string.error_msg))
                }

            })
        }
    }

}