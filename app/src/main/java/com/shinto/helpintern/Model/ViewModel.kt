package com.shinto.helpintern

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shinto.helpintern.Data.Get.JobListDataClass
import com.shinto.helpintern.Data.Post.UserRegistration
import com.shinto.helpintern.Repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository) : ViewModel() {

    var joblistResponse: MutableLiveData<Response<List<JobListDataClass>>> = MutableLiveData()
    var registerResponse: MutableLiveData<Response<List<UserRegistration>>> = MutableLiveData()

    fun registration(userRegistration: UserRegistration) {
        viewModelScope.launch {
            val response: Response<List<UserRegistration>> =
                repository.postUserRegistration(userRegistration)
            registerResponse.value = response
        }
    }

    fun getJobList() {
        viewModelScope.launch {
            val getJobResponse: Response<List<JobListDataClass>> = repository.getJobList()
            joblistResponse.value = getJobResponse
        }
    }
}