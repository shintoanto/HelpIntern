package com.shinto.helpintern.Model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shinto.helpintern.Data.Get.ServiceListItem
import kotlinx.coroutines.launch

class ServiceViewModel(val serviceDetails: ServiceListItem) : ViewModel() {

    val City: MutableLiveData<String> = MutableLiveData()
    val Province: MutableLiveData<String> = MutableLiveData()
    val Country: MutableLiveData<String> = MutableLiveData()
    val discription: MutableLiveData<String> = MutableLiveData()

    init {
        serviceName()
    }

    private fun serviceName() {
        City.value = serviceDetails.city!!
        Province.value = serviceDetails.province!!
        Country.value = serviceDetails.country!!
        discription.value = serviceDetails.description!!
    }

}

