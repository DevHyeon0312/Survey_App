package com.devhyeon.survey.network.repository

import com.devhyeon.survey.network.model.*
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

    override suspend fun postTake(take : Any?) : TakeResult {
        return surveyService.postTake(take)
    }

    override suspend fun getSurveyTakeResult(userId:Any?, titleId:Any?) : TakeResult {
        return surveyService.getSurveyTakeResult(userId,titleId)
    }

}