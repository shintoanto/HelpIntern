package com.shinto.helpintern.Data.Get

import com.google.gson.annotations.SerializedName

data class AccomodationDataClassItem(
    @SerializedName("accommodationType")
    val accommodationType: String? = null,
    @SerializedName("bedsAvailable")
    val bedsAvailable: Int? = null,
    @SerializedName("city")
    val city: String? = null,
    @SerializedName("country")
    val country: String? = null,
    @SerializedName("coverPhoto")
    val coverPhoto: String? = null,
    @SerializedName("createdAt")
    val createdAt: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("isAvailable")
    val isAvailable: Boolean? = null,
    @SerializedName("isHeating")
    val isHeating: Boolean? = null,
    @SerializedName("isParking")
    val isParking: Boolean? = null,
    @SerializedName("isSmoking")
    val isSmoking: Boolean? = null,
    @SerializedName("isWifi")
    val isWifi: Boolean? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("phoneNumber")
    val phoneNumber: Int? = null,
    @SerializedName("province")
    val province: String? = null,
    @SerializedName("rentAmount")
    val rentAmount: Int? = null,
    @SerializedName("street")
    val street: String? = null,
    @SerializedName("updatedAt")
    val updatedAt: String? = null,
    @SerializedName("userId")
    val userId: Int? = null,
    @SerializedName("zipCode")
    val zipCode: Int? = null
)