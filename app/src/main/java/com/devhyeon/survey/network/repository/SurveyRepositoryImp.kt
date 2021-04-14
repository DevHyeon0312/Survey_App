package com.devhyeon.survey.network.repository

import com.devhyeon.survey.data.dto.Survey
import com.devhyeon.survey.network.model.ApiResult
import com.devhyeon.survey.network.model.TitleResult
import com.devhyeon.survey.network.service.SurveyService
import retrofit2.http.Path

class SurveyRepositoryImp(private val surveyService: SurveyService) : SurveyRepository {

    override suspend fun getSurveys(): TitleResult {
        return surveyService.getSurveys()
    }

    override suspend fun getSurveyDetail(titleId:Any?) : ApiResult {
        return surveyService.getSurveyDetail(titleId)
    }

    override suspend fun postSurveyCreate(survey: Any?): ApiResult {
        return surveyService.postCreateSurvey(survey)
    }
}