package com.devhyeon.survey.network.service

import com.devhyeon.survey.network.model.Survey
import retrofit2.http.GET

interface SurveyService {
    /**
     * 설문 전체 조회
     * */
    @GET("/survey/getSurveyTitle")
    suspend fun getSurveys() : List<Survey>

    /**
     * 설문 상세 조회
     * */


    /**
     * 설문 등록
     * */

    /**
     * 설문 참여
     * */

}