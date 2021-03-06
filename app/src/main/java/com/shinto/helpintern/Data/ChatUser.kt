package com.shinto.helpintern.Data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ChatUser(
    val name: String,
    val id: String
) : Parcelable
