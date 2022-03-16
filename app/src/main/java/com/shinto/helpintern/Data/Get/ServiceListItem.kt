package com.shinto.helpintern.Data.Get

data class ServiceListItem(
    val city: String,
    val country: String,
    val created_at: String,
    val description: String,
    val id: Int,
    val is_available: Boolean,
    val minimum_wage: Int,
    val province: String,
    val service_provider: Int,
    val service_types: String,
    val updated_at: String
)