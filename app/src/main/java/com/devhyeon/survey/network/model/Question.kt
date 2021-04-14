package com.devhyeon.survey.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Question(
    var question_id : Int,
    val question_msg : String, //문항질문
    val answers : List<Answer> //문항에 대한 답변
)