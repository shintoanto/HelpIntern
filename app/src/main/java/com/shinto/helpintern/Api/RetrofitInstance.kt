package com.shinto.helpintern.Api

import com.shinto.helpintern.Util.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val retrofitIntace: HelpInterApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(HelpInterApi::class.java)
    }
}

// Configure Google Sign In
//val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//    .requestIdToken(getString(R.string.default_web_client_id))
//    .requestEmail()
//    .build()
//
//googleSignInClient = GoogleSignIn.getClient(this, gso)