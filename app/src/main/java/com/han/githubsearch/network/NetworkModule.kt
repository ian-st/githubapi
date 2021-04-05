package com.han.githubsearch.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory



const val URL_GITHUB_SEARCH_API = "https://api.github.com/search/"

class NetworkModule {
    var retrofit: Retrofit

    init {
        retrofit = createRetrofit()
    }

    private fun createRetrofit(): Retrofit {

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

    private fun getCommonGson(): Gson = GsonBuilder()
        .excludeFieldsWithoutExposeAnnotation().create()

    fun <T> getApiService(service: Class<T>) = retrofit.create(service)
}