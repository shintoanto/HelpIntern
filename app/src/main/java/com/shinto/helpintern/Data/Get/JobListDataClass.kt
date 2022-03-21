package com.shinto.helpintern.Data.Get

import android.os.Parcelable
import androidx.versionedparcelable.VersionedParcelize
import kotlinx.android.parcel.Parcelize


@Parcelize
data class JobListDataClass(
    val city: String,
    val company: Int,
    val companyName: String,
    val description: String,
    val designation: String,
    val id: Int,
    val jobType: String,
    val minimumWage: Int,
    val provider: Int,
    val providerName: String,
    val province: String,
    val requirements: String
):Parcelable