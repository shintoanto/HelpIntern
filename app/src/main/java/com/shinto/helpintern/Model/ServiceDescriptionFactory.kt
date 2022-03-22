package com.shinto.helpintern.Model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shinto.helpintern.Data.Get.ServiceListItem

class ServiceDescriptionFactory(val serviceDetails: ServiceListItem) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ServiceViewModel(serviceDetails) as T
    }

}
