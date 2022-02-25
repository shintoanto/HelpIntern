package com.shinto.helpintern.Api

import com.shinto.helpintern.Data.JobListDataClass
import retrofit2.http.GET

interface HelpInterApi {

    @GET("/user/job-list")
    suspend fun JobList():JobListDataClass


}