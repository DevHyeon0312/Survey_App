package com.devhyeon.survey.network.repository

import com.devhyeon.survey.network.model.ApiResult
import com.devhyeon.survey.network.model.Survey

interface SurveyRepository {
    suspend fun getSurveys() : ApiResult

    suspend fun getSurveyDetail(titleId : Any?) : ApiResult
}