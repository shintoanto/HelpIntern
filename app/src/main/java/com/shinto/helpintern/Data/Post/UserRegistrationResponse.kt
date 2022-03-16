package com.shinto.helpintern.Data.Post

data class UserRegistrationResponse(
    val email: String,
    val first_name: String,
    val id: Int,
    val last_name: String,
    val phone_number: String,
    val profile_picture: String,
    val username: String
)