package com.shinto.helpintern.Api

import com.shinto.helpintern.Data.JobListDataClass
import com.shinto.helpintern.Data.Job_Provider
import retrofit2.Response
import retrofit2.http.GET

interface HelpInterApi {

    @GET("user/job-list")
    suspend fun JobList(): Response<List<JobListDataClass>>

}