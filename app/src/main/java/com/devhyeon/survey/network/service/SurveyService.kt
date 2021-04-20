package com.devhyeon.survey.network.service

import com.devhyeon.survey.network.model.*
import retrofit2.http.*

interface SurveyService {
    /** 설문 전체 조회 */
    @GET("/survey/getSurveyTitle")
    suspend fun getSurveys() : TitleResult

    /** 설문 상세 조회 */
    @GET("/survey/getSurveyDetail")
    suspend fun getSurveyDetail(@Query("titleId") titleID : Any?) : SurveyResult

    /** 설문 등록 */
    @POST("/survey/createSurvey")
    suspend fun postCreateSurvey(@Body survey : Any?) : ApiResult

    /** 설문 참여 */
    @POST("/survey/addResult")
    suspend fun postTake(@Body take : Any?) : TakeResult

    /** 설문 참여 결과 */
    @GET("/survey/getResult")
    suspend fun getSurveyTakeResult(@Query("userId") userId:Any?, @Query("titleId") titleID: Any?) : TakeResult

}