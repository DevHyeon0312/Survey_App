package com.devhyeon.survey.network.repository

import com.devhyeon.survey.network.model.ApiResult
import com.devhyeon.survey.network.model.Survey
import com.devhyeon.survey.network.model.TitleResult

interface SurveyRepository {
    suspend fun getSurveys() : TitleResult

    suspend fun getSurveyDetail(titleId : Any?) : ApiResult
}