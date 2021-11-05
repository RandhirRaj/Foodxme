package com.randhir.foodxme.model.login

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.ArrayList

data class Customer (

    @SerializedName("customer_guid")
    @Expose
    val customerGuid: String?,

    @SerializedName("username")
    @Expose
    val username: String?,

    @SerializedName("email")
    @Expose
    val email: String?,

    @SerializedName("first_name")
    @Expose
    val firstName: String?,

    @SerializedName("last_name")
    @Expose
    val lastName: String?,

    @SerializedName("phone_number")
    @Expose
    val phoneNumber: String?,

    @SerializedName("language_id")
    @Expose
    val languageId: String?,

    @SerializedName("date_of_birth")
    @Expose
    val dateOfBirth: String?,

    @SerializedName("gender")
    @Expose
    val gender: String?,

    @SerializedName("admin_comment")
    @Expose
    val adminComment: String?,

    @SerializedName("is_tax_exempt")
    @Expose
    val isTaxExempt: Boolean?,

    @SerializedName("has_shopping_cart_items")
    @Expose
    val hasShoppingCartItems: Boolean?,

    @SerializedName("active")
    @Expose
    val active: Boolean?,

    @SerializedName("deleted")
    @Expose
    val deleted : Boolean?,

    @SerializedName("is_system_account")
    @Expose
    val isSystemAccount: Boolean?,

    @SerializedName("system_name")
    @Expose
    val systemName: String?,

    @SerializedName("last_ip_address")
    @Expose
    val lastIpAddress: String?,

    @SerializedName("created_on_utc")
    @Expose
    val createdOnUtc: String?,

    @SerializedName("last_login_date_utc")
    @Expose
    val lastLoginDateUtc: String?,

    @SerializedName("last_activity_date_utc")
    @Expose
    val lastActivityDateUtc: String?,

    @SerializedName("registered_in_store_id")
    @Expose
    val registeredInStoreId: Int?,

    @SerializedName("subscribed_to_newsletter")
    @Expose
    val subscribedToNewsLetter: Boolean?,

    @SerializedName("role_ids")
    @Expose
    val roleIds : ArrayList<Int>?,

    @SerializedName("id")
    @Expose
    val id: Int?
)

