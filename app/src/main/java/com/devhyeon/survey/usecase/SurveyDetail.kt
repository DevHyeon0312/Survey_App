package com.devhyeon.survey.usecase

import com.devhyeon.survey.network.model.ApiResult
import com.devhyeon.survey.network.repository.SurveyRepository
import com.devhyeon.survey.usecase.base.ApiUseCase

class SurveyDetail (private val surveyRepository: SurveyRepository): ApiUseCase<ApiResult, Any?>() {

    override suspend fun run(params: Any?): ApiResult {
        return surveyRepository.getSurveyDetail(params)
    }

}