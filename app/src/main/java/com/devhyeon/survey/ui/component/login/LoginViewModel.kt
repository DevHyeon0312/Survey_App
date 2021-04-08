package com.devhyeon.survey.ui.component.login

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devhyeon.survey.SPLASH_DELAY
import com.devhyeon.survey.utils.*
import kotlinx.coroutines.*

class LoginViewModel(private val ctx: Context) : ViewModel() {
    val loginData = MutableLiveData<Status<String>>()

    fun doLogin() {
        viewModelScope.launch {
            if (ctx.isNetworkAvailable()) {
                runCatching {
                    val id : String = getNowDate()
                    loginData.value = Status.Run(id)
                    if (getPreferencesString(context = ctx, key = "ID", defaultValue = "").isEmpty()) {
                        setPreferencesString(context = ctx, key = "ID", value = id)
                    }
                }.onSuccess {
                    withContext(Dispatchers.Default) {
                        delay(SPLASH_DELAY.toLong())
                    }
                    loginData.value = Status.Success(getPreferencesString(context = ctx, key = "ID", defaultValue = ""))
                }.onFailure {
                    loginData.value = Status.Failure(1)
                    it.printStackTrace()
                }
            } else {
                loginData.value = Status.Failure(2)
            }
        }
    }
}