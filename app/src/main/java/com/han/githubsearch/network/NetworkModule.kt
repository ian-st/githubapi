package com.han.githubsearch.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


/**
 *
 * Copyright ⓒ LOTTESHOPPING Co., LTD. All rights reserved.
 *
 * Created by hlee10(hlee10@lotte.net) on 05, 04, 2021..
 *
 */

val URL_GITHUB_SEARCH_API = "https://api.github.com/search/"

class NetworkModule {
    var retrofit: Retrofit

    init {
        retrofit = createRetrofit()
    }

    fun createRetrofit(): Retrofit {

        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl(URL_GITHUB_SEARCH_API)
            .callFactory(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(getCommonGson()))
            .build()
    }

    protected fun getCommonGson(): Gson {
        val commonJson = GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation().create()
        return commonJson
    }

    fun <T> getApiService(service: Class<T>) = retrofit.create(service)
}