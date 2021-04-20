package com.devhyeon.survey.di

import com.bumptech.glide.Glide
import com.bumptech.glide.annotation.GlideModule
import com.devhyeon.survey.network.SurveyViewModel
import com.devhyeon.survey.ui.component.create.CreateViewModel
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
        CreateViewModel()
    }

    viewModel {
        SurveyViewModel(get(), get(), get(), get() , get())
    }

    single { createSurveyTitle(get()) }

    single { createSurveyDetail(get())}

    single { createSurveyAdd(get())}

    single { createSurveyRepository(get()) }

    single { createSurveyTake(get()) }

    single { createSurveyTakeResult(get()) }

}