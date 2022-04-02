package com.shinto.helpintern.Data.Post

import com.google.gson.annotations.SerializedName

data class UserLogin(
    @SerializedName("email")
    val email: String? = null,
    @SerializedName("password")
    val password: String? = null
)
