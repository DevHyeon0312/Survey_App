package com.devhyeon.survey.network.usecase

import com.devhyeon.survey.data.dto.Survey
import com.devhyeon.survey.network.model.ApiResult
import com.devhyeon.survey.network.model.TitleResult
import com.devhyeon.survey.network.repository.SurveyRepository
import com.devhyeon.survey.network.usecase.base.ApiUseCase

class PostSurveyCreate(private val surveyRepository: SurveyRepository): ApiUseCase<ApiResult, Any?>() {

    override suspend fun run(params: Any?): ApiResult {
        return surveyRepository.postSurveyCreate(params)
    }
}