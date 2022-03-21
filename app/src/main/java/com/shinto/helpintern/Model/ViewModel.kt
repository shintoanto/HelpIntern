package com.shinto.helpintern

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shinto.helpintern.Data.Get.AccomodationDataClassItem
import com.shinto.helpintern.Data.Get.JobListDataClass
import com.shinto.helpintern.Data.Get.ServiceListItem
import com.shinto.helpintern.Data.Post.UserRegistration
import com.shinto.helpintern.Data.Post.UserRegistrationResponse
import com.shinto.helpintern.Repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository) : ViewModel() {

    var joblistResponse: MutableLiveData<Response<List<JobListDataClass>>> = MutableLiveData()
    var registerResponse: MutableLiveData<Response<List<UserRegistration>>> =
        MutableLiveData()
    val accomodationResponse: MutableLiveData<Response<List<AccomodationDataClassItem>>> =
        MutableLiveData()
    val serviceResponse: MutableLiveData<Response<List<ServiceListItem>>> = MutableLiveData()

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
            if (response.isSuccessful) {
                Log.d("Nam", response.toString())
            } else {
                Log.d("Nam", "error")
            }
            // registerResponse.value = response
        }
    }

    fun getJobList() {
        viewModelScope.launch {
            val getJobResponse: Response<List<JobListDataClass>> = repository.getJobList()
            joblistResponse.value = getJobResponse
        }
    }
}