package com.shinto.helpintern.Repository

import com.shinto.helpintern.Api.RetrofitInstance
import com.shinto.helpintern.Data.Get.AccomodationDataClassItem
import com.shinto.helpintern.Data.Get.JobListDataClass
import com.shinto.helpintern.Data.Get.ServiceListItem
import com.shinto.helpintern.Data.LoginTokenResponse
import com.shinto.helpintern.Data.Post.UserLogin
import com.shinto.helpintern.Data.Post.UserRegistration
import com.shinto.helpintern.Data.Post.UserRegistrationResponse
import retrofit2.Response

class Repository {

    suspend fun userLogin(userLogin: UserLogin): Response<LoginTokenResponse> =
        RetrofitInstance.retrofitIntace.userLogin(userLogin)

    suspend fun getJobList(): Response<List<JobListDataClass>> =
        RetrofitInstance.retrofitIntace.JobList()

//    suspend fun postUserRegistration(userRegistration: UserRegistration): Response<UserRegistrationResponse> {
//        return RetrofitInstance.retrofitIntace.userRegister(userRegistration)
//    }

    suspend fun getAccomodationList(): Response<List<AccomodationDataClassItem>> =
        RetrofitInstance.retrofitIntace.userAccomodationListApi()

    suspend fun userServiceLists(): Response<List<ServiceListItem>> =
        RetrofitInstance.retrofitIntace.serviceList()

    suspend fun postUserRegistration(userRegistration: UserRegistration): Response<UserRegistrationResponse> {
        return RetrofitInstance.retrofitIntace.userRegister(userRegistration)
    }
}

