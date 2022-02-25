package com.shinto.helpintern

import com.shinto.helpintern.Api.HelpInterApi
import com.shinto.helpintern.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofitIntace by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val HelpInterApi: HelpInterApi by lazy {
        retrofitIntace.create(HelpInterApi::class.java)
    }
}