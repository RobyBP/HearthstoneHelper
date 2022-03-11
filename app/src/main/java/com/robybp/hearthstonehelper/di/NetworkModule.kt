package com.robybp.hearthstonehelper.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.robybp.hearthstonehelper.BuildConfig
import com.robybp.hearthstonehelper.network.CardsService
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
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
        val httpInterceptor = HttpLoggingInterceptor()
        httpInterceptor.level = HttpLoggingInterceptor.Level.BODY
        OkHttpClient.Builder().addInterceptor(Interceptor { chain ->
            val requestBuilder = chain.request().newBuilder()
            requestBuilder
                .addHeader("x-rapidapi-host", BuildConfig.RAPID_API_HOST)
                .addHeader("x-rapidapi-key", BuildConfig.RAPID_API_KEY)
            chain.proceed(requestBuilder.build())
        })
            .addInterceptor(httpInterceptor)
            .build()
    }

    single {
        provideRetrofit(get(), get())
    }

    single {
        provideCardService(get())
    }
}

@OptIn(ExperimentalSerializationApi::class)
private fun provideRetrofit(deserializer: Json, okHttpClient: OkHttpClient) =
    Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(deserializer.asConverterFactory("application/json".toMediaTypeOrNull()!!))
        .client(okHttpClient)
        .build()

private fun provideCardService(retrofit: Retrofit) = retrofit.create(CardsService::class.java)
