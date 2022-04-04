package com.shinto.helpintern

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shinto.helpintern.Data.Get.AccomodationDataClassItem
import com.shinto.helpintern.Data.Get.JobListDataClass
import com.shinto.helpintern.Data.Get.ServiceListItem
import com.shinto.helpintern.Data.Post.UserLogin
import com.shinto.helpintern.Data.Post.UserRegistration
import com.shinto.helpintern.Data.Post.UserRegistrationResponse
import com.shinto.helpintern.Repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import java.lang.Exception
import java.util.*

class MainViewModel(private val repository: Repository) : ViewModel() {

    var userLoginResponse: MutableLiveData<Response<UserLogin>> = MutableLiveData()
    var joblistResponse: MutableLiveData<Resource<List<JobListDataClass>>> = MutableLiveData()
    var registerResponse: MutableLiveData<Response<UserRegistrationResponse>> =
        MutableLiveData()
    val accomodationResponse: MutableLiveData<Resource<List<AccomodationDataClassItem>>> =
        MutableLiveData()
    val serviceResponse: MutableLiveData<Resource<List<ServiceListItem>>> = MutableLiveData()

    var signUp: MutableLiveData<Resource<String>> = MutableLiveData()
    var logIn: MutableLiveData<Resource<LogInResponse>> = MutableLiveData()

    var mainView = ObservableField(true)

    val email = MutableLiveData<String>()
    val exception = MutableLiveData<String>()
    val first_name = MutableLiveData<String>()
    val last_name = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val phone_number = MutableLiveData<String>()
    val repassword = MutableLiveData<String>()
    val username = MutableLiveData<String>()

    var isEmailValid: Boolean = false
    var isFirstName: Boolean = false
    var isLastName: Boolean = false
    var isUserName: Boolean = false
    var isPhoneValid: Boolean = false
    var isPassword: Boolean = false
    var isRepassword: Boolean = false

    var logInEmain = MutableLiveData<String>()
    var passwordLogIN = MutableLiveData<String>()
    var isPasswordValied = false


    private var isSignUp: MutableLiveData<Boolean> = MutableLiveData()
    val _isSignUp: LiveData<Boolean>
        get() = isSignUp

    init {
        getJobList()
        accomodationList()
        userList()
    }

    fun mainVisibility(setCondition: Boolean) {
        if (setCondition) {
            this.mainView.set(true)
        } else {
            this.mainView.set(false)
        }
    }

    fun userLoginViewModel(userLogin: UserLogin) {
        viewModelScope.launch {
            val response: Response<UserLogin> =
                repository.userLogin(userLogin)
            userLoginResponse.value = response
        }
    }


    fun signUpRegistrationData(userRegistration: UserRegistration) {
        viewModelScope.launch {
            try {
                signUp.postValue(Resource.Loading())
                val response = repository.postUserRegistration(userRegistration)
                signUp.postValue(handleResponse(response))
            } catch (error: Exception) {
                exception.value = error.toString()
            }
        }
    }
    fun logInData(logInData: UserLogin) = viewModelScope.launch {

        try {
            logIn.postValue(Resource.Loading())
            val response = repository.logInDetails(logInData)
            Log.i("response", response.toString())
            logIn.postValue(handleResponse(response))

        } catch (error: Exception) {
            Log.i("responseL", error.toString())

        }
    }

    private fun handleResponse(response: Response<UserRegistrationResponse>): Resource<String> {
        if (response.isSuccessful) {
            isSignUp.value = true
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse.toString())
            }
        } else {
            response.body()?.let { resultResponse ->
                isSignUp.value = false
                return Resource.Error(resultResponse.toString())
            }
        }
        return Resource.Error(response.message())
    }

    private fun accomodationList() {
        viewModelScope.launch {
            accomodationResponse.postValue(Resource.Loading())
            val accomodationResponses = repository.getAccomodationList()
            accomodationResponse.postValue(handleAccomResponse(accomodationResponses))
        }
    }

    private fun userList() {
        viewModelScope.launch {
            serviceResponse.postValue(Resource.Loading())
            val serviceRes = repository.userServiceLists()
            serviceResponse.postValue(handleServiceResponse(serviceRes))
        }
    }

//    fun registration(userRegistration: UserRegistration) {
//        viewModelScope.launch {
//            val response: Response<UserRegistrationResponse> =
//                repository.postUserRegistration(userRegistration)
//            registerResponse.value = response
//
//            if (response.isSuccessful) {
//                Log.d("Nam", response.toString())
//            } else {
//                Log.d("Nam", "error is :" + response.code().toString())
//            }
//        }
//    }

    private fun getJobList() {
        viewModelScope.launch(Dispatchers.IO) {
            joblistResponse.postValue(Resource.Loading())
            val response = repository.getJobList()
            joblistResponse.postValue(handleHelpInternResponse(response))
        }
    }

    private fun handleHelpInternResponse(response: Response<List<JobListDataClass>>): Resource<List<JobListDataClass>> {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }

    private fun handleAccomResponse(response: Response<List<AccomodationDataClassItem>>): Resource<List<AccomodationDataClassItem>> {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }

    private fun handleServiceResponse(response: Response<List<ServiceListItem>>): Resource<List<ServiceListItem>> {
        if (response.isSuccessful) {
            response.body()?.let { serviceREs ->
                return Resource.Success(serviceREs)
            }
        }
        return Resource.Error(response.message())
    }

}