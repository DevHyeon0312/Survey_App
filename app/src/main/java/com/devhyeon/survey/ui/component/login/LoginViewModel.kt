package com.devhyeon.survey.ui.component.login

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devhyeon.survey.SPLASH_DELAY
import com.devhyeon.survey.network.SurveyViewModel
import com.devhyeon.survey.utils.*
import kotlinx.coroutines.*

class LoginViewModel(private val ctx: Context) : ViewModel() {
    val loginData = MutableLiveData<Status<Long>>()

    fun doLogin() {
        viewModelScope.launch {
            if (ctx.isNetworkAvailable()) {
                runCatching {
                    val id : Long = getNowDate().toLong()
                    loginData.value = Status.Run(id)
                    if (getPreferencesLong(context = ctx, key = "ID", defaultValue = 0L) == 0L) {
                        setPreferencesLong(context = ctx, key = "ID", value = id)
                    }
                }.onSuccess {
                    withContext(Dispatchers.Default) {
                        delay(SPLASH_DELAY.toLong())
                    }
                    loginData.value = Status.Success(getPreferencesLong(context = ctx, key = "ID", defaultValue = 0L))
                }.onFailure {
                    loginData.value = Status.Failure(1)
                    it.printStackTrace()
                }
            } else {
                loginData.value = Status.Failure(2)
            }
        }
    }

    companion object {
        private val TAG = LoginViewModel::class.java.name
    }
}