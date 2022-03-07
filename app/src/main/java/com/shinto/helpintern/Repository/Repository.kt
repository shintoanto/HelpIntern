package com.shinto.helpintern.Repository

import com.shinto.helpintern.Data.JobListDataClass
import com.shinto.helpintern.Data.Job_Provider
import com.shinto.helpintern.RetrofitInstance
import retrofit2.Response

class Repository {

    suspend fun getJobList(): Response<List<JobListDataClass>> {
        return RetrofitInstance.HelpInterApi.JobList()
    }

}