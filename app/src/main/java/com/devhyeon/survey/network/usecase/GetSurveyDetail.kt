package com.devhyeon.survey.network.usecase

import com.devhyeon.survey.network.model.Survey
import com.devhyeon.survey.network.model.ApiResult
import com.devhyeon.survey.network.model.SurveyResult
import com.devhyeon.survey.network.repository.SurveyRepository
import com.devhyeon.survey.network.usecase.base.ApiUseCase

class GetSurveyDetail (private val surveyRepository: SurveyRepository): ApiUseCase<SurveyResult, Any?>() {

    override suspend fun run(params: Any?): SurveyResult {
        return surveyRepository.getSurveyDetail(params)
    }

}