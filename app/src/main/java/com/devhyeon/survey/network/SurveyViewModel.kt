package com.devhyeon.survey.network

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devhyeon.survey.network.model.ApiError
import com.devhyeon.survey.network.model.ApiResult
import com.devhyeon.survey.usecase.SurveyDetail
import com.devhyeon.survey.usecase.SurveyTitle
import com.devhyeon.survey.usecase.base.ApiResponse
import kotlinx.coroutines.cancel

class SurveyViewModel constructor(
        private val surveyTitle: SurveyTitle,
        private val surveyDetail: SurveyDetail
    ) : ViewModel()  {

    val postsData = MutableLiveData<ApiResult>()
    val showProgressbar = MutableLiveData<Boolean>()
    val messageData = MutableLiveData<String>()

    fun getSurveys() {
        showProgressbar.value = true
        surveyTitle.invoke(viewModelScope, null, object : ApiResponse<ApiResult> {
            override fun onSuccess(result: ApiResult) {
                Log.i(TAG, "result: $result")
                postsData.value = result
                showProgressbar.value = false
            }

            override fun onError(apiError: ApiError?) {
                messageData.value = apiError?.getErrorMessage()
                showProgressbar.value = false
            }
        })
    }

    fun getDetail(titleId:Int) {
        showProgressbar.value = true
        surveyDetail.invoke(viewModelScope, titleId, object : ApiResponse<ApiResult> {
            override fun onSuccess(result: ApiResult) {
                Log.i(TAG, "result: $result")
                postsData.value = result
                showProgressbar.value = false
            }

            override fun onError(apiError: ApiError?) {
                messageData.value = apiError?.getErrorMessage()
                showProgressbar.value = false
            }
        })
    }

    override fun onCleared() {
        viewModelScope.cancel()
        super.onCleared()
    }

    companion object {
        private val TAG = SurveyViewModel::class.java.name
    }
}