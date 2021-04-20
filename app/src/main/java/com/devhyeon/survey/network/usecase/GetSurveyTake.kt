package com.devhyeon.survey.network.usecase

import com.devhyeon.survey.network.model.ApiResult
import com.devhyeon.survey.network.model.TakeResult
import com.devhyeon.survey.network.repository.SurveyRepository
import com.devhyeon.survey.network.usecase.base.ApiUseCase
import com.devhyeon.survey.network.usecase.base.ApiUseCase2

class GetSurveyTake(private val surveyRepository: SurveyRepository): ApiUseCase2<TakeResult, Any?>() {
    override suspend fun run(p1: Any?, p2: Any?): TakeResult {
        return surveyRepository.getSurveyTakeResult(p1,p2)
    }
}