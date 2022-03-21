package com.shinto.helpintern.Data.Get

data class AccomodationDataClassItem(
    val accommodationType: String,
    val bedsAvailable: Int,
    val city: String,
    val country: String,
    val coverPhoto: String,
    val createdAt: String,
    val id: Int,
    val isAvailable: Boolean,
    val isHeating: Boolean,
    val isParking: Boolean,
    val isSmoking: Boolean,
    val isWifi: Boolean,
    val name: String,
    val phoneNumber: Int,
    val province: String,
    val rentAmount: Int,
    val street: String,
    val updatedAt: String,
    val userId: Int,
    val zipCode: Int
)