package com.shinto.helpintern.Model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shinto.helpintern.Data.Get.JobListDataClass

class JobDescriptionDetails(val jobData: JobListDataClass) : ViewModel() {

    val companyName: MutableLiveData<String> = MutableLiveData()
    val jobPosition: MutableLiveData<String> = MutableLiveData()
    val minimunWage: MutableLiveData<Int> = MutableLiveData()
    val jobDescription: MutableLiveData<String> = MutableLiveData()

    init {
        setJobDetailsValues()
    }

    fun setJobDetailsValues() {
        if (jobData.companyName != null) {
            companyName.value = jobData.companyName!!
        } else {
            companyName.value = "Company name"
        }
        if (jobData.jobType != null) {
            jobPosition.value = jobData.jobType!!
        } else {
            jobPosition.value = "Job position"
        }
        if (jobData.minimumWage != null) {
            minimunWage.value = jobData.minimumWage!!
        } else {
            minimunWage.value = 0
        }
        if (jobData.description != null) {
            jobDescription.value = jobData.description!!
        } else {
            jobDescription.value = "Job Description"
        }
    }
}