package com.devhyeon.survey

import android.app.Application
import com.bumptech.glide.annotation.GlideModule
import com.devhyeon.survey.di.AppModule
import com.devhyeon.survey.di.NetworkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/** Application : Koin modules 등록 */

open class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    AppModule,
                    NetworkModule
                )
            )
        }
    }
}
