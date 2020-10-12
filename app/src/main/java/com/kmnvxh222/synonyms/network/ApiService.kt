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
private const val PARAMETER_REQUEST_LANG = "lang=ru"

private const val PARAMETER_REQUEST_SCORES = "scores=0"
private const val PARAMETER_REQUEST_TOP = "top"
private const val PARAMETER_REQUEST_FORM = "forms"
private const val PARAMETER_REQUEST_FORMS_FORMAT= "format=json"

//FORMS
private const val PARAMETER_REQUEST_TOP_FORMS = "$PARAMETER_REQUEST_TOP=1"
private const val PARAMETER_REQUEST_FORM_FORMS = "$PARAMETER_REQUEST_FORM=1"

//ROOT
private const val PARAMETER_REQUEST_TOP_ROOT = "$PARAMETER_REQUEST_TOP=10"
private const val PARAMETER_REQUEST_FORM_ROOT = "$PARAMETER_REQUEST_FORM=0"

//SYNS
private const val PARAMETER_REQUEST_TOP_SYNS = "$PARAMETER_REQUEST_TOP=10"
private const val PARAMETER_REQUEST_FORM_SYNS = "$PARAMETER_REQUEST_FORM=0"

private const val REQUEST= "api?$TOKEN_REQUEST&"+
        "$PARAMETER_REQUEST_LANG&" +
        "$PARAMETER_REQUEST_SCORES"

private const val FORMS_REQUEST= "$REQUEST$PARAMETER_REQUEST_FORMS_C&" +
        "$PARAMETER_REQUEST_FORMS_FORMAT&" +
        "$PARAMETER_REQUEST_TOP_FORMS&" +
        "$PARAMETER_REQUEST_FORM_FORMS"
private const val SYNS_REQUEST="$REQUEST$PARAMETER_REQUEST_SYNS_C&" +
        "$PARAMETER_REQUEST_TOP_SYNS&" +
        "$PARAMETER_REQUEST_FORM_SYNS"
private const val ROOT_REQUEST="$REQUEST$PARAMETER_REQUEST_ROOT_C&" +
        "$PARAMETER_REQUEST_TOP_ROOT&" +
        "$PARAMETER_REQUEST_FORM_ROOT"


interface ApiService {
    @GET("/api?token=4e902aa5795143135853e81625bfb3f7dd0ed956&c=syns&query=кот&lang=ru&top=5&forms=0&scores=0")
    fun getSyns(@Query("query") query: String): Observable<Response<GetOne<Syn>>>

    @GET("/api?token=4e902aa5795143135853e81625bfb3f7dd0ed956&c=root&query=кот&lang=ru&top=10&forms=0&scores=0")
    fun getRoot(@Query("query") query: String): Observable<Response<GetOne<Root>>>

    @GET("/api?token=4e902aa5795143135853e81625bfb3f7dd0ed956&c=vector&query=кот&lang=ru&top=1&forms=1&scores=0")
    fun getForms(@Query("query") query: String): Observable<Response<GetOne<Forms>>>

}