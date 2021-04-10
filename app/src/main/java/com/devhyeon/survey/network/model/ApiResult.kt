package com.devhyeon.survey.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiResult (
    val resultData : Any?,
    val resultStatus : Any?
)