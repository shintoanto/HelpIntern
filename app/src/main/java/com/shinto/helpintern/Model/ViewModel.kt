package com.shinto.helpintern

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shinto.helpintern.Data.Get.AccomodationDataClassItem
import com.shinto.helpintern.Data.Get.JobListDataClass
import com.shinto.helpintern.Data.Get.ServiceListItem
import com.shinto.helpintern.Data.Post.UserLogin
import com.shinto.helpintern.Data.Post.UserRegistration
import com.shinto.helpintern.Data.Post.UserRegistrationResponse
import com.shinto.helpintern.Repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository) : ViewModel() {

    var userLoginResponse: MutableLiveData<Response<UserLogin>> = MutableLiveData()
    var joblistResponse: MutableLiveData<Resource<JobListDataClass>> = MutableLiveData()
    var registerResponse: MutableLiveData<Response<UserRegistrationResponse>> =
        MutableLiveData()
    val accomodationResponse: MutableLiveData<Response<List<AccomodationDataClassItem>>> =
        MutableLiveData()
    val serviceResponse: MutableLiveData<Response<List<ServiceListItem>>> = MutableLiveData()

    init {
        getJobList()
    }

    fun userLoginViewModel(userLogin: UserLogin) {
        viewModelScope.launch {
            val response: Response<UserLogin> =
                repository.userLogin(userLogin)
            userLoginResponse.value = response
        }
    }

    fun userList() {
        viewModelScope.launch {
            val response: Response<List<ServiceListItem>> =
                repository.userServiceLists()
            serviceResponse.value = response
        }
    }

    fun accomodationList() {
        viewModelScope.launch {
            val response: Response<List<AccomodationDataClassItem>> =
                repository.getAccomodationList()
            accomodationResponse.value = response
        }
    }

    fun registration(userRegistration: UserRegistration) {
        viewModelScope.launch {
            val response: Response<UserRegistrationResponse> =
                repository.postUserRegistration(userRegistration)
            registerResponse.value = response

            if (response.isSuccessful) {
                Log.d("Nam", response.toString())
            } else {
                Log.d("Nam", "error is :" + response.code().toString())
            }
        }
    }

    private fun getJobList() {
        viewModelScope.launch(Dispatchers.IO) {
            joblistResponse.postValue(Resource.Loading())
            val response = repository.getJobList()
            joblistResponse.postValue(handleHelpInternResponse(response))
        }
    }

    private fun handleHelpInternResponse(response: Response<JobListDataClass>): Resource<JobListDataClass> {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }

}