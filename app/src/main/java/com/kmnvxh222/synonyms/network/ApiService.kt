package com.kmnvxh222.synonyms.network

import com.kmnvxh222.synonyms.model.remote.Response
import com.kmnvxh222.synonyms.model.remote.Syn
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

private const val TOKEN = "4e902aa5795143135853e81625bfb3f7dd0ed956"

interface ApiService {
    @GET("/api?token=$TOKEN&c=syns&lang=ru&top=5&forms=0&scores=0")
//    fun getSyns(@Query("query") query: String): LiveData<ApiResponse<Syn?>>
    fun getSyns(@Query("query") query: String): Deferred<Response<Syn>>

//    @GET("/api?token=$TOKEN&c=root&lang=ru&top=10&forms=0&scores=0")
//    fun getRoot(@Query("query") query: String): Deferred<Response<Root>>
//
//    @GET("/api?token=$TOKEN&c=vector&lang=ru&top=1&forms=1&scores=0")
//    fun getForms(@Query("query") query: String): Deferred<Response<Forms>>

}