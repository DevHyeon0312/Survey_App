package com.devhyeon.survey.data.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Survey (
    val title: String,
    val questions : List<Question>
)