package com.devhyeon.survey.network.usecase

import com.devhyeon.survey.network.model.ApiResult
import com.devhyeon.survey.network.model.TakeResult
import com.devhyeon.survey.network.repository.SurveyRepository
import com.devhyeon.survey.network.usecase.base.ApiUseCase

class PostSurveyTake(private val surveyRepository: SurveyRepository): ApiUseCase<TakeResult, Any?>() {

    override suspend fun run(params: Any?): TakeResult {
        return surveyRepository.postTake(params)
    }
}