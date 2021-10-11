package com.example.usetech3.network

import com.example.usetech3.network.ApiService.gson
import com.example.usetech3.network.api.SuperHeroApi
import com.example.usetech3.utils.Constants
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private val client = getInterceptorClient()

private val retrofit = Retrofit.Builder()
    .baseUrl(Constants.URL_BASE)
    .client(client)
    .addConverterFactory(GsonConverterFactory.create(gson))
    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    .build()

private fun getInterceptorClient(): OkHttpClient {
    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY

    return OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .readTimeout(30, TimeUnit.SECONDS)
        .connectTimeout(30, TimeUnit.SECONDS)
        .build()
}

object ApiService {
    val gson: Gson by lazy {
        GsonBuilder().setLenient().create()
    }

    val userApi: SuperHeroApi by lazy {
        retrofit.create(SuperHeroApi::class.java)
    }
}