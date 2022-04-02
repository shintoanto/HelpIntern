package com.shinto.helpintern.Data.Post

import com.google.gson.annotations.SerializedName

data class UserRegistration(
    @SerializedName("email")
    val email: String? = null,
    @SerializedName("first_name")
    val first_name: String? = null,
    @SerializedName("last_name")
    val last_name: String? = null,
    @SerializedName("password")
    val password: String? = null,
    @SerializedName("phone_number")
    val phone_number: String? = null,
    @SerializedName("repassword")
    val repassword: String? = null,
    @SerializedName("username")
    val username: String? = null
)