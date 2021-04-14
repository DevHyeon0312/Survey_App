package com.devhyeon.survey.network.repository

import com.devhyeon.survey.network.model.ApiResult
import com.devhyeon.survey.network.model.Survey
import com.devhyeon.survey.network.model.SurveyResult
import com.devhyeon.survey.network.model.TitleResult
import com.devhyeon.survey.network.service.SurveyService

class SurveyRepositoryImp(private val surveyService: SurveyService) : SurveyRepository {

    override suspend fun getSurveys(): TitleResult {
        return surveyService.getSurveys()
    }

    override suspend fun getSurveyDetail(titleId:Any?) : SurveyResult {
        return surveyService.getSurveyDetail(titleId)
    }

    override suspend fun postSurveyCreate(survey: Any?): ApiResult {
        return surveyService.postCreateSurvey(survey)
    }
}