package com.kmnvxh222.synonyms.repository.remote

import android.annotation.SuppressLint
import android.util.Log
import com.kmnvxh222.synonyms.model.remote.Forms
import com.kmnvxh222.synonyms.model.remote.Root
import com.kmnvxh222.synonyms.model.remote.Syn
import com.kmnvxh222.synonyms.network.RetrofitApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RemoteRepositoryImpl:RemoteRepositoryInterface {

    override fun getDataForms(query: String): Forms? {
        var formData: Forms? = null
        val observable = RetrofitApi.retrofitApiService.getForms(query)
        observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { response ->
                    formData = response.response?.one
                    Log.d("RemoteRepository", "FORMS ${response}")
                },
                { error ->
                    Log.d("RemoteRepository", "error ${error}")
                }
            )
        return formData
    }

    override fun getDataRoot(query: String): Root? {
        var rootData: Root? = null
        val observable = RetrofitApi.retrofitApiService.getRoot(query)
        observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { response ->
                    rootData = response.response?.one
                    Log.d("RemoteRepository", "ROOT ${response}")
                },
                { error ->
                    Log.d("RemoteRepository", "error ${error}")
                }
            )
        return rootData
    }

    override fun getDataSyns(query: String): Syn? {
        var synsData: Syn? = null
        val observable = RetrofitApi.retrofitApiService.getSyns(query)
        observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { response ->
                    synsData = response.response?.one
                    Log.d("RemoteRepository", "SYNS ${response}")
                },
                { error ->
                    Log.d("RemoteRepository", "error ${error}")
                }
            )
        return synsData
    }
}