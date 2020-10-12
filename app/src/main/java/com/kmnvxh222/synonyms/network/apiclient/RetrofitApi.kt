package com.kmnvxh222.synonyms.network.apiclient

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.kmnvxh222.synonyms.network.ApiService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


private val BASE_URL = "http://paraphraser.ru/"

object RetrofitApi {

    private var gson: Gson = GsonBuilder()
        .setLenient()
        .create()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()

    val retrofitApiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}

