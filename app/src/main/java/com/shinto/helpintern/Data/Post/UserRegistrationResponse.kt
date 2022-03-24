package com.shinto.helpintern.Data.Post

import java.io.File

data class UserRegistrationResponse(
    val email: String,
    val first_name: String,
    val id: Int,
    val last_name: String,
    val phone_number: String,
    val username: String,
    val password: String,
    val profile_picture: String,
    val repassword: String
)