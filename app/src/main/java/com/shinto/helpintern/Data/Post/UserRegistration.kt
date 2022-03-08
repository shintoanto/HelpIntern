package com.shinto.helpintern.Data.Post

data class UserRegistration(
    val email: String,
    val first_name: String,
    val last_name: String,
    val password: String,
    val phone_number: String,
    val profile_picture: Any,
    val repassword: String,
    val username: String
)