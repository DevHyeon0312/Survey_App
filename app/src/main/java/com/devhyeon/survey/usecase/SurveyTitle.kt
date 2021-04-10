package com.devhyeon.survey.usecase

import com.devhyeon.survey.network.model.ApiResult
import com.devhyeon.survey.network.model.TitleResult
import com.devhyeon.survey.network.repository.SurveyRepository
import com.devhyeon.survey.usecase.base.ApiUseCase

class SurveyTitle (private val surveyRepository: SurveyRepository): ApiUseCase<TitleResult, Any?>() {

    override suspend fun run(params: Any?): TitleResult {
        return surveyRepository.getSurveys()
    }
}