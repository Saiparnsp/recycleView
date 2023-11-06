package com.example.homeworkcycleview.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Portal {
    private val loggerInterceptor: HttpLoggingInterceptor by lazy {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }
    fun <T> createPortal(classy: Class<T>): T {
        val httpBuilder = OkHttpClient.Builder().apply {
            addInterceptor(loggerInterceptor)
        }

        val httpClient = httpBuilder
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BaseUrl.getBaseUrl())
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient)
            .build()
        return retrofit.create(classy)
    }
}