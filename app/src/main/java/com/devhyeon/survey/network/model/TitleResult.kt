package com.devhyeon.survey.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TitleResult(
    val resultData : List<SurveyTitle>,
    val resultStatus : Any?
)