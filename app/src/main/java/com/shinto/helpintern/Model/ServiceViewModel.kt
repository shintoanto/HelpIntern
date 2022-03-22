package com.shinto.helpintern.Model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shinto.helpintern.Data.Get.ServiceListItem
import kotlinx.coroutines.launch

class ServiceViewModel(val serviceDetails: ServiceListItem) : ViewModel() {

    val nameService: MutableLiveData<String> = MutableLiveData()

    init {
        serviceName()
    }

    private fun serviceName() = viewModelScope.launch {
        nameService.value = serviceDetails.description
    }

}

