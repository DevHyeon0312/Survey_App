package com.devhyeon.survey.ui.component.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devhyeon.survey.utils.Status
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    val loginData = MutableLiveData<Status<String>>()

    fun doLogin(id : String) {
        viewModelScope.launch {
            runCatching {
                System.out.println("Dev -> Run")
                loginData.value = Status.Run("LOADING")
            }.onSuccess {
                System.out.println("Dev -> Success")
                loginData.value = Status.Success("SUCCESS")
            }.onFailure {
                System.out.println("Dev -> FAIL")
                loginData.value = Status.Failure(1)
                it.printStackTrace()
            }
        }
    }
}