package com.devhyeon.survey.di

import com.devhyeon.survey.BASE_URL
import com.devhyeon.survey.network.repository.SurveyRepository
import com.devhyeon.survey.network.repository.SurveyRepositoryImp
import com.devhyeon.survey.network.service.SurveyService
import com.devhyeon.survey.network.usecase.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

import com.squareup.moshi.Moshi

private const val TIME_OUT = 30L

val NetworkModule = module {
    single { createService(get()) }

    single { createRetrofit(get(), BASE_URL) }

    single { createOkHttpClient() }

    single { MoshiConverterFactory.create() }

    single { Moshi.Builder().build() }
}

fun createOkHttpClient(): OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
    return OkHttpClient.Builder()
        .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
        .readTimeout(TIME_OUT, TimeUnit.SECONDS)
        .addInterceptor(httpLoggingInterceptor).build()
}

fun createRetrofit(okHttpClient: OkHttpClient, url: String): Retrofit {
    return Retrofit.Builder()
        .baseUrl(url)
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create()).build()
}

fun createService(retrofit: Retrofit): SurveyService {
    return retrofit.create(SurveyService::class.java)
}

fun createSurveyRepository(apiService: SurveyService): SurveyRepository {
    return SurveyRepositoryImp(apiService)
}

fun createSurveyTitle(surveyRepository: SurveyRepository): GetSurveyTitle {
    return GetSurveyTitle(surveyRepository)
}

fun createSurveyDetail(surveyRepository: SurveyRepository): GetSurveyDetail {
    return GetSurveyDetail(surveyRepository)
}

fun createSurveyAdd(surveyRepository: SurveyRepository): PostSurveyCreate {
    return PostSurveyCreate(surveyRepository)
}

fun createSurveyTakeResult(surveyRepository: SurveyRepository): GetSurveyTake {
    return GetSurveyTake(surveyRepository)
}

fun createSurveyTake(surveyRepository: SurveyRepository): PostSurveyTake {
    return PostSurveyTake(surveyRepository)
}

