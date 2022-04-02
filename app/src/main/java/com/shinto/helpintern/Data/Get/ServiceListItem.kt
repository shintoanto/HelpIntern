package com.shinto.helpintern.Data.Get

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ServiceListItem(
    @SerializedName("city")
    val city: String? = null,
    @SerializedName("country")
    val country: String? = null,
    @SerializedName("createdAt")
    val createdAt: String? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("isAvailable")
    val isAvailable: Boolean? = null,
    @SerializedName("minimumWage")
    val minimumWage: Int? = null,
    @SerializedName("province")
    val province: String? = null,
    @SerializedName("serviceProvider")
    val serviceProvider: Int? = null,
    @SerializedName("serviceTypes")
    val serviceTypes: String? = null,
    @SerializedName("updatedAt")
    val updatedAt: String? = null
) : Parcelable