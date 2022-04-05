package com.shinto.helpintern.Model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shinto.helpintern.Data.Get.ServiceListItem

class ServiceDiscriptionDetails(val serv: ServiceListItem) : ViewModel() {
    val cityName: MutableLiveData<String> = MutableLiveData()
    val province: MutableLiveData<String> = MutableLiveData()
    val country: MutableLiveData<String> = MutableLiveData()
    val description: MutableLiveData<String> = MutableLiveData()

    init {
        setServiceDetailsValues()
    }

    fun setServiceDetailsValues() {
        cityName.value = serv.city!!
        province.value = serv.province!!
        country.value = serv.country!!
        description.value = serv.description!!

    }

}