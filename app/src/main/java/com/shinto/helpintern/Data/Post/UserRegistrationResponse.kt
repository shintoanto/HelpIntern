package com.shinto.helpintern.Data.Post

data class UserRegistrationResponse(
    val email: String? = null,
    val firstName: String? = null,
    val id: Int? = null,
    val lastName: String? = null,
    val phoneNumber: String? = null,
    val profilePicture: String? = null,
    val userName: String? = null
)