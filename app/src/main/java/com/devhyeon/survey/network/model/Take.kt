package com.devhyeon.survey.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Take(
    val userId : Long,
    val titleId : Long,
    val userAnsList : List<UserAns>?,
    val countList : Map<Long,Map<Long,Int>>?
)

@JsonClass(generateAdapter = true)
data class UserAns(
    val questionId : Long,
    val answerId : Long
)