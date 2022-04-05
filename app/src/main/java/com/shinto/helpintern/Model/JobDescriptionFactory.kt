package com.shinto.helpintern.Model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shinto.helpintern.Data.Get.JobListDataClass

class JobDescriptionFactory(var job: JobListDataClass) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return JobDescriptionDetails(job) as T
    }
}