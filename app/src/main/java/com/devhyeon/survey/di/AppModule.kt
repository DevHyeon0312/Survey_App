package com.devhyeon.survey.di

import com.bumptech.glide.Glide
import com.bumptech.glide.annotation.GlideModule
import com.devhyeon.survey.network.SurveyViewModel
import com.devhyeon.survey.ui.component.home.HomeViewModel
import com.devhyeon.survey.ui.component.login.LoginViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val AppModule = module {
    viewModel {
        LoginViewModel(get())
    }

    viewModel {
        HomeViewModel()
    }

    viewModel {
        SurveyViewModel(get(), get())
    }

    single { createSurveyTitle(get()) }

    single { createSurveyDetail(get())}

    single { createSurveyRepository(get()) }
}