package com.devhyeon.survey.network.repository

import com.devhyeon.survey.network.model.Survey

interface SurveyRepository {
    suspend fun getSurveys() : List<Survey>
}