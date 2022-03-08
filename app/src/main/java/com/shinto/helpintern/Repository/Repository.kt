package com.shinto.helpintern.Repository

import com.shinto.helpintern.Data.JobListDataClass
import com.shinto.helpintern.Api.RetrofitInstance
import retrofit2.Response

class Repository {

    suspend fun getJobList(): Response<List<JobListDataClass>> =
         RetrofitInstance.retrofitIntace.JobList()


}