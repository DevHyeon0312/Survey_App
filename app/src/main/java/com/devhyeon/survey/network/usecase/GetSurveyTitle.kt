package com.devhyeon.survey.network.usecase

import com.devhyeon.survey.network.model.TitleResult
import com.devhyeon.survey.network.repository.SurveyRepository
import com.devhyeon.survey.network.usecase.base.ApiUseCase

class GetSurveyTitle (private val surveyRepository: SurveyRepository): ApiUseCase<TitleResult, Any?>() {

    override suspend fun run(params: Any?): TitleResult {
        return surveyRepository.getSurveys()
    }
}