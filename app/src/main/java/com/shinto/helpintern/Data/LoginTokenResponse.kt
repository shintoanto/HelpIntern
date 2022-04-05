package com.shinto.helpintern.Data

import com.google.gson.annotations.SerializedName

data class LoginTokenResponse(
    @SerializedName("refresh")
    val refreshToken:String,
    @SerializedName("access")
    val accessToken:String
)
