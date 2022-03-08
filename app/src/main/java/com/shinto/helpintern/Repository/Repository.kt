package com.shinto.helpintern.Repository

import com.shinto.helpintern.Data.Get.JobListDataClass
import com.shinto.helpintern.Api.RetrofitInstance
import com.shinto.helpintern.Data.Post.UserRegistration
import retrofit2.Response

class Repository {

    suspend fun getJobList(): Response<List<JobListDataClass>> =
        RetrofitInstance.retrofitIntace.JobList()

    suspend fun postUserRegistration(userRegistration: UserRegistration): Response<List<UserRegistration>> =
        RetrofitInstance.retrofitIntace.userRegister(userRegistration)

}