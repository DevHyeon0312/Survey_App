package com.devhyeon.survey.network.model

import android.icu.text.CaseMap
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SurveyDetail (
    val title : Title,
    val questions : List<Question>
)

@JsonClass(generateAdapter = true)
data class Title (
    val title: String
)