package com.devhyeon.survey.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Answer (
    var answer_id : Int,
    val answer_msg : String
)