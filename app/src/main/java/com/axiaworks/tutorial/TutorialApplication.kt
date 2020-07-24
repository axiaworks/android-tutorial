package com.axiaworks.tutorial

import android.app.Application
import com.axiaworks.tutorial.mvvm.Tutorial6ViewModel
import com.axiaworks.tutorial.mvvm.repository.QiitaRepository
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class TutorialApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Property.context = applicationContext
        setupKoin()
    }

    private fun setupKoin() {
        val module: Module = module {
            viewModel { Tutorial6ViewModel() }
            single { createRetrofitService("https://qiita.com/", QiitaRepository::class.java) }
        }

        startKoin {
            androidLogger()
            androidContext(this@TutorialApplication)
            modules(module)
        }
    }

    private fun <T> createRetrofitService(baseUrl: String, service: Class<T>): T =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(
                MoshiConverterFactory.create(
                    Moshi.Builder()
                        .add(KotlinJsonAdapterFactory())
                        .build()
                )
            )
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(
                OkHttpClient
                    .Builder()
                    .addInterceptor(
                        HttpLoggingInterceptor().apply {
                            level = HttpLoggingInterceptor.Level.BASIC
                        })
                    .build()
            )
            .build()
            .create(service)
}