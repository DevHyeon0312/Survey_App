package com.devhyeon.survey.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Survey (
    val title: String,
    val questions : List<Question>
)