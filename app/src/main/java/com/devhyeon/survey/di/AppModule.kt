package com.devhyeon.survey.di

import com.devhyeon.survey.ui.component.home.HomeViewModel
import com.devhyeon.survey.ui.component.login.LoginViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val AppModule = module {
    viewModel {
        LoginViewModel(get())
        HomeViewModel()
    }
}