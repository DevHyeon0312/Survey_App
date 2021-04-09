package com.devhyeon.survey.di

import com.devhyeon.survey.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

import com.squareup.moshi.Moshi
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

private const val TIME_OUT = 30L

val NetworkModule = module {
//    single { createService(get()) }
//
//    single { createRetrofit(get(), BASE_URL) }
//
//    single { createOkHttpClient() }
//
//    single { MoshiConverterFactory.create() }
//
//    single { Moshi.Builder().build() }

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

//fun createService(retrofit: Retrofit): ApiService {
//    return retrofit.create(ApiService::class.java)
//}
//
//fun createPostRepository(apiService: ApiService): PostsRepository {
//    return PostsRepositoryImp(apiService)
//}
//
//fun createGetPostsUseCase(postsRepository: PostsRepository): GetPostsUseCase {
//    return GetPostsUseCase(postsRepository)
//}
