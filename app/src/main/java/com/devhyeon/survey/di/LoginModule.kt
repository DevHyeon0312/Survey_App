package com.devhyeon.survey.di

import com.devhyeon.survey.ui.component.login.LoginViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val LoginModule = module {
    viewModel {
        LoginViewModel()
    }
}
