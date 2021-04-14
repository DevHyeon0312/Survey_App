package com.devhyeon.survey.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SurveyResult (
    val resultData : SurveyDetail,
    val resultStatus : Any?
)
