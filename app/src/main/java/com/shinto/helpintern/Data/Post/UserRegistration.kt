package com.shinto.helpintern.Data.Post

import java.io.File

data class UserRegistration(
    val email: String,
    val firstName: String,
    val lastName: String,
    val password: String,
    val phoneNumber: String,
    val profilePicture: File,
    val repassword: String,
    val username: String
)