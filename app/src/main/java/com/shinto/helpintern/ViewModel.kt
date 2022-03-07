package com.shinto.helpintern

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shinto.helpintern.Data.JobListDataClass
import com.shinto.helpintern.Data.Job_Provider
import com.shinto.helpintern.Repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository) : ViewModel() {

    var joblistResponse: MutableLiveData<Response<List<JobListDataClass>>> = MutableLiveData()

    fun getJobList() {
        viewModelScope.launch {
            val getJobResponse: Response<List<JobListDataClass>> = repository.getJobList()
            joblistResponse.value = getJobResponse
        }
    }
}