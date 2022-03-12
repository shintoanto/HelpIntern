package com.shinto.helpintern.Data.Get

data class AccomodationDataClassItem(
    val accommodation_type: String,
    val beds_available: Int,
    val city: String,
    val country: String,
    val cover_photo: String,
    val created_at: String,
    val id: Int,
    val is_available: Boolean,
    val is_heating: Boolean,
    val is_parking: Boolean,
    val is_smoking: Boolean,
    val is_wifi: Boolean,
    val name: String,
    val phone_number: Int,
    val province: String,
    val rent_amount: Int,
    val street: String,
    val updated_at: String,
    val user_id: Int,
    val zip_code: Int
)