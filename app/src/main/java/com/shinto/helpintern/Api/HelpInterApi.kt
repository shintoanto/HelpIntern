package com.shinto.helpintern.Api

import com.shinto.helpintern.Data.Get.AccomodationDataClassItem
import com.shinto.helpintern.Data.Get.JobListDataClass
import com.shinto.helpintern.Data.Post.UserRegistration
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface HelpInterApi {
    @GET("user/job-list")
    suspend fun JobList(): Response<List<JobListDataClass>>

    @POST("user/register")
    suspend fun userRegister(
        @Body userRegistration: UserRegistration
    ): Response<List<UserRegistration>>


    @GET("user/accommodation-list-filter")
    suspend fun userAccomodationListApi(): Response<List<AccomodationDataClassItem>>
}