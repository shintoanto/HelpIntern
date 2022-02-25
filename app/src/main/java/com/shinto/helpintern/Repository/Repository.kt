package com.shinto.helpintern.Repository

import com.shinto.helpintern.Data.JobListDataClass
import com.shinto.helpintern.RetrofitInstance

class Repository {

    suspend fun getJobList():JobListDataClass{
        return RetrofitInstance.HelpInterApi.JobList()
    }
}