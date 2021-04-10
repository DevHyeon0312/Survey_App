package com.devhyeon.survey.network

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devhyeon.survey.network.model.Survey
import com.devhyeon.survey.network.model.TitleResult
import com.devhyeon.survey.usecase.SurveyDetail
import com.devhyeon.survey.usecase.SurveyTitle
import com.devhyeon.survey.utils.Status
import kotlinx.coroutines.*

class SurveyViewModel constructor(
        private val surveyTitle: SurveyTitle,
        private val surveyDetail: SurveyDetail
    ) : ViewModel()  {

    val statusData = MutableLiveData<Status<List<Survey>>>()

    fun getSurveys() {
        viewModelScope.launch {
            var result : TitleResult? = null
            runCatching {
                result = surveyTitle.run(null)
                statusData.value = Status.Run()
            }.onSuccess {
                statusData.value = Status.Success(result!!.resultData)
            }.onFailure {
                statusData.value = Status.Failure(-1)
            }
        }
    }

    override fun onCleared() {
        System.out.println("onCleared 호출")
        super.onCleared()
        viewModelScope.cancel()
        SupervisorJob().cancel()
    }

    companion object {
        private val TAG = SurveyViewModel::class.java.name
    }
}