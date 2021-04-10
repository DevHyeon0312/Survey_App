package com.devhyeon.survey.network.service

import com.devhyeon.survey.network.model.ApiResult
import com.devhyeon.survey.network.model.Survey
import com.devhyeon.survey.network.model.TitleResult
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SurveyService {
    /**
     * 설문 전체 조회
     * */
    @GET("/survey/getSurveyTitle")
    suspend fun getSurveys() : TitleResult

    /**
     * 설문 상세 조회
     * */
    @GET("/survey/getSurveyDetail")
    suspend fun getSurveyDetail(@Query("titleId") titleID : Any?) : ApiResult

    /**
     * 설문 등록
     * */

    /**
     * 설문 참여
     * */

}