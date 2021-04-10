package com.devhyeon.survey.ui.component.home

import androidx.annotation.IdRes
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devhyeon.survey.R
import com.devhyeon.survey.ui.component.login.LoginViewModel
import com.devhyeon.survey.utils.Status
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel(){
    val navigationData = MutableLiveData<Status<Int>>()

    var result : Int = 0
    fun clickNavigation(@IdRes id:Int) {
        viewModelScope.launch {
            runCatching {
                navigationData.value = Status.Run(result)
                when(id) {
                    R.id.menu_home -> {
                        result = 1
                    }
                    R.id.menu_survey -> {
                        result = 2
                    }
                    R.id.menu_info -> {
                        result = 3
                    }
                }
            }.onSuccess {
                navigationData.value = Status.Success(result)
            }.onFailure {
                navigationData.value = Status.Failure(-1)
            }
        }
    }

    companion object {
        private val TAG = HomeViewModel::class.java.name
    }
}