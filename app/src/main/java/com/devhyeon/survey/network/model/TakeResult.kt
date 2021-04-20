package com.devhyeon.survey.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TakeResult(
    val resultData : Take?,
    val resultStatus : Any?
)