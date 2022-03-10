package com.robybp.hearthstonehelper.di

import com.robybp.hearthstonehelper.BuildConfig
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit

val retrofitModule = module {

    single {
        Json {
            ignoreUnknownKeys = true
            classDiscriminator = "component"
        }
    }

    single {
        OkHttpClient().networkInterceptors().add(Interceptor { chain ->
            val requestBuilder = chain.request().newBuilder()
            requestBuilder
                .addHeader("x-rapidapi-host", BuildConfig.RAPID_API_HOST)
                .addHeader("x-rapidapi-key", BuildConfig.RAPID_API_KEY)
            chain.proceed(requestBuilder.build())
        })
    }

    single {
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(get())
            .client(get())
    }
}
