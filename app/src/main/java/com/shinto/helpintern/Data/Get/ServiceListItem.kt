package com.shinto.helpintern.Data.Get

data class ServiceListItem(
    val city: String,
    val country: String,
    val createdAt: String,
    val description: String,
    val id: Int,
    val isAvailable: Boolean,
    val minimumWage: Int,
    val province: String,
    val serviceProvider: Int,
    val serviceTypes: String,
    val updatedAt: String
)