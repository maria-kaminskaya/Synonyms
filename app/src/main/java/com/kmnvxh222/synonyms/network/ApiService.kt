package com.kmnvxh222.synonyms.network

import com.kmnvxh222.synonyms.model.*
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

private const val LOGIN = "km_nvxh"
private const val PASSWORD = "vhxAKXv3JB7e88N"
private const val TOKEN = "4e902aa5795143135853e81625bfb3f7dd0ed956"
private const val TOKEN_REQUEST="token=$TOKEN"
private const val PARAMETER_REQUEST_C="c"
private const val PARAMETER_REQUEST_FORMS_C = "$PARAMETER_REQUEST_C=vector"
private const val PARAMETER_REQUEST_SYNS_C = "$PARAMETER_REQUEST_C=syns"
private const val PARAMETER_REQUEST_ROOT_C = "$PARAMETER_REQUEST_C=root"
private const val PARAMETER_REQUEST_SCORES = "scores=0"
private const val PARAMETER_REQUEST_TOP = "top=5"
private const val PARAMETER_REQUEST_FORM = "forms=1"
private const val PARAMETER_REQUEST_LANG = "lang=ru"
private const val PARAMETER_REQUEST_FORMS_FORMAT= "format=json"

private const val REQUEST= "api?$TOKEN_REQUEST&"+
        "$PARAMETER_REQUEST_SCORES&" +
        "$PARAMETER_REQUEST_TOP&" +
        "$PARAMETER_REQUEST_FORM&" +
        "$PARAMETER_REQUEST_LANG&"

private const val FORMS_REQUEST= "$REQUEST$PARAMETER_REQUEST_FORMS_C&$PARAMETER_REQUEST_FORMS_FORMAT"
private const val SYNS_REQUEST="$REQUEST$PARAMETER_REQUEST_SYNS_C"
private const val ROOT_REQUEST="$REQUEST$PARAMETER_REQUEST_ROOT_C"


interface ApiService {
    @GET("?$SYNS_REQUEST")
    fun getSyns(@Query("query") query: String): Observable<Response<Syn>>

    @GET("?$ROOT_REQUEST")
    fun getRoot(@Query("query") query: String): Observable<Response<Root>>

    @GET("?$FORMS_REQUEST")
    fun getForms(@Query("query") query: String): Observable<Response<r>>
}