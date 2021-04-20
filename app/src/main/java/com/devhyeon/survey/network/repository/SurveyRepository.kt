package com.devhyeon.survey.network.repository

import com.devhyeon.survey.network.model.*
import retrofit2.http.Body
import retrofit2.http.Query

interface SurveyRepository {
    suspend fun getSurveys() : TitleResult

    suspend fun getSurveyDetail(titleId : Any?) : SurveyResult

    suspend fun postSurveyCreate(survey: Any?) : ApiResult

    suspend fun postTake(take : Any?) : ApiResult

    suspend fun getSurveyTakeResult(userId : Any?, titleId : Any?) : TakeResult

}