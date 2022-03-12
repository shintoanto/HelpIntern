package com.shinto.helpintern.Data.Get

import android.os.Parcelable
import androidx.versionedparcelable.VersionedParcelize
import kotlinx.android.parcel.Parcelize


@Parcelize
data class JobListDataClass(
    val city: String,
    val company: Int,
    val company_name: String,
    val description: String,
    val designation: String,
    val id: Int,
    val job_type: String,
    val minimum_wage: Int,
    val provider: Int,
    val provider_name: String,
    val province: String,
    val requirements: String
):Parcelable