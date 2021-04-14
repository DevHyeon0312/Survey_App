package com.devhyeon.survey.data.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Answer (
    var answer_id : Int,
    val answer_msg : String
)