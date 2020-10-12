package com.kmnvxh222.synonyms.repository.remote

import android.annotation.SuppressLint
import android.util.Log
import com.kmnvxh222.synonyms.model.Forms
import com.kmnvxh222.synonyms.model.Root
import com.kmnvxh222.synonyms.model.Syn
import com.kmnvxh222.synonyms.network.apiclient.RetrofitApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RemoteRepository() {

    @SuppressLint("CheckResult")
    fun getDataForms(): Forms? {
        var formData: Forms? = null
        val observable = RetrofitApi.retrofitApiService.getForms("кот")
        observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { response ->
                    Log.d("RemoteRepository", "FORMS ${response}")
                },
                { error ->
                    Log.d("RemoteRepository", "error ${error}")
                }
            )
        return formData
    }

    @SuppressLint("CheckResult")
    fun getDataRoot(): Root? {
        var rootData: Root? = null
        val observable = RetrofitApi.retrofitApiService.getRoot("кот")
        observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { response ->

                    Log.d("RemoteRepository", "ROOT ${response}")
                },
                { error ->
                    Log.d("RemoteRepository", "error ${error}")
                }
            )
        return rootData
    }

    @SuppressLint("CheckResult")
    fun getDataSyns(): Syn? {
        var synsData: Syn? = null
        val observable = RetrofitApi.retrofitApiService.getSyns("кот")
        observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { response ->

                    Log.d("RemoteRepository", "SYNS ${response}")
                },
                { error ->
                    Log.d("RemoteRepository", "error ${error}")
                }
            )
        return synsData
    }
}