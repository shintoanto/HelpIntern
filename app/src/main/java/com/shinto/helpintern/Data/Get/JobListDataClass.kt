package com.shinto.helpintern.Data.Get

import android.os.Parcelable
import androidx.versionedparcelable.VersionedParcelize
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class JobListDataClass(
    @SerializedName("city")
    val city: String? = null,
    @SerializedName("company")
    val company: Int? = null,
    @SerializedName("companyName")
    val companyName: String? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("designation")
    val designation: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("jobType")
    val jobType: String? = null,
    @SerializedName("minimumWage")
    val minimumWage: Int? = null,
    @SerializedName("provider")
    val provider: Int? = null,
    @SerializedName("providerName")
    val providerName: String? = null,
    @SerializedName("province")
    val province: String? = null,
    @SerializedName("requirements")
    val requirements: String? = null
) : Parcelable