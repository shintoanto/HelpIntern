package com.shinto.helpintern.Api

import com.shinto.helpintern.Data.Get.AccomodationDataClassItem
import com.shinto.helpintern.Data.Get.JobListDataClass
import com.shinto.helpintern.Data.Get.ServiceListItem
import com.shinto.helpintern.Data.Post.LoginTokenResponse
import com.shinto.helpintern.Data.Post.UserLogin
import com.shinto.helpintern.Data.Post.UserRegistration
import com.shinto.helpintern.Data.Post.UserRegistrationResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface HelpInterApi {

    @GET("user/job-list")
    suspend fun JobList(): Response<List<JobListDataClass>>

    @Headers("Content-Type: application/json")
    @POST("user/register/")
    suspend fun userRegister(
        @Body userRegistration: UserRegistration
    ): Response<UserRegistrationResponse>

    @POST("api/token/")
    suspend fun userLogin(
        @Body userRegistration: UserLogin
    ): Response<LoginTokenResponse>

    @GET("user/accommodation-list-filter")
    suspend fun userAccomodationListApi(): Response<List<AccomodationDataClassItem>>

    @GET("user/service-list-filter")
    suspend fun serviceList(): Response<List<ServiceListItem>>

}