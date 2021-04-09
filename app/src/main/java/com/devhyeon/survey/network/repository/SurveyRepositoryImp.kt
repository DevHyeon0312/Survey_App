package com.devhyeon.survey.network.repository

import com.devhyeon.survey.network.model.Survey
import com.devhyeon.survey.network.service.SurveyService

class SurveyRepositoryImp(private val surveyService: SurveyService) : SurveyRepository {

    override suspend fun getSurveys(): List<Survey> {
        return surveyService.getSurveys()
    }

}