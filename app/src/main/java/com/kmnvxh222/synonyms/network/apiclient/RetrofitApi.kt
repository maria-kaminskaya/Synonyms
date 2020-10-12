package com.kmnvxh222.synonyms.network.apiclient

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.kmnvxh222.synonyms.network.ApiService
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.lang.reflect.Type


private val BASE_URL = "http://paraphraser.ru/"

object RetrofitApi {

    private var gson: Gson = GsonBuilder()
        .setLenient()
        .create()

    private fun createGsonConverter(type: Type, typeAdapter: Any): Converter.Factory {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.registerTypeAdapter(type, typeAdapter)
        val gson = gsonBuilder
            .setLenient()
            .create()
        return GsonConverterFactory.create(gson)
    }

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
//        .addConverterFactory(
//            createGsonConverter(
//                object : TypeToken<List<Item?>?>() {}.type,
//                JsonDataDeserializer()
//            )
//        )
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()

    val retrofitApiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}

