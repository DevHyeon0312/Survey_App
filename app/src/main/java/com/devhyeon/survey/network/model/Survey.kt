package com.devhyeon.survey.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Survey (
    val id : Long,
    val title : String
)