package com.devhyeon.survey

import android.app.Application
import com.devhyeon.survey.di.LoginModule
import com.devhyeon.survey.ui.component.login.LoginViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

/** Application : Koin modules 등록 */

open class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    LoginModule
                )
            )
        }
    }
}
