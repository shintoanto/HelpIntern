package com.shinto.helpintern

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shinto.helpintern.Data.JobListDataClass
import com.shinto.helpintern.Repository.Repository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository) : ViewModel() {

    var joblistResponse: MutableLiveData<JobListDataClass> = MutableLiveData()

    fun getJobList() {
        viewModelScope.launch {
            val getJobResponse: JobListDataClass = repository.getJobList()
            joblistResponse.value = getJobResponse
        }
    }
}