package com.shinto.helpintern.Api

import com.shinto.helpintern.Data.JobListDataClass
import com.shinto.helpintern.UserRegistration
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST

interface HelpInterApi {
    @GET("user/job-list")
    suspend fun JobList(): Response<List<JobListDataClass>>

    @POST("/user/register/")
    suspend fun userRegister(): Response<List<UserRegistration>>
}