package com.devhyeon.survey.network

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devhyeon.survey.network.model.ApiResult
import com.devhyeon.survey.network.model.SurveyTitle
import com.devhyeon.survey.network.model.TitleResult
import com.devhyeon.survey.network.usecase.GetSurveyDetail
import com.devhyeon.survey.network.usecase.GetSurveyTitle
import com.devhyeon.survey.network.usecase.PostSurveyCreate
import com.devhyeon.survey.utils.Status
import kotlinx.coroutines.*

class SurveyViewModel constructor(
    private val surveyTitle: GetSurveyTitle,
    private val surveyDetail: GetSurveyDetail,
    private val surveyCreate: PostSurveyCreate
    ) : ViewModel()  {

    val statusData = MutableLiveData<Status<List<SurveyTitle>>>()
    val createdData = MutableLiveData<Status<ApiResult>>()

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

    fun postCreateSurvey(params: Any?) {
        viewModelScope.launch {
            var result : ApiResult? = null
            kotlin.runCatching {
                result = surveyCreate.run(params)
                statusData.value = Status.Run()
            }.onSuccess {
                createdData.value = Status.Success(result!!)
            }.onFailure {
                createdData.value = Status.Failure(-1)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
        SupervisorJob().cancel()
    }

    companion object {
        private val TAG = SurveyViewModel::class.java.name
    }
}