package com.shinto.helpintern

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shinto.helpintern.Repository.Repository

class ViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}