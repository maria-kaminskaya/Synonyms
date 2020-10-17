package com.kmnvxh222.synonyms.repository.remote

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.kmnvxh222.synonyms.model.remote.Syn
import com.kmnvxh222.synonyms.network.RetrofitApi
import com.kmnvxh222.synonyms.repository.async.AsyncRepositoryInterface
import kotlinx.coroutines.*

class RemoteRepositoryImpl : RemoteRepositoryInterface, AsyncRepositoryInterface {

    private var job = Job()
    private val coroutineScope = CoroutineScope(job + Dispatchers.Main)

//    override fun getDataForms(query: String): MutableLiveData<Forms?> {
//        val formData = MutableLiveData<Forms?>()
//        try {
//            coroutineScope.launch {
//                val response = RetrofitApi.retrofitApiService.getForms(query)
//                formData.value = response.await().response?.get("1")
//                Log.d("RemoteRepository", " FORM ${response.isCompleted}")
//                Log.d("RemoteRepository", " FORM ${formData.value}")
//            }
//        } catch (e: Exception) {
//            Log.d("RemoteRepository", "error FORM ${e}")
//        }
//        return formData
//    }
//
//    override fun getDataRoot(query: String): MutableLiveData<Root?> {
//        val rootData = MutableLiveData<Root?>()
//        try {
//            coroutineScope.launch {
//                val response = RetrofitApi.retrofitApiService.getRoot(query)
//                rootData.value = response.await().response?.get("1")
//                Log.d("RemoteRepository", " ROOT ${response.isCompleted}")
//                Log.d("RemoteRepository", " ROOT ${rootData.value}")
//            }
//        } catch (e: Exception) {
//            Log.d("RemoteRepository", "error ROOT ${e}")
//        }
//        return rootData
//    }

    override fun getDataSyns(query: String): MutableLiveData<Syn?> {
        val synsData = MutableLiveData<Syn?>()
        try {
            coroutineScope.launch {
                val response = RetrofitApi.retrofitApiService.getSyns(query)
                synsData.value = response.await().response?.get("1")
                Log.d("RemoteRepository", " SYNS ${response.isCompleted}")
                Log.d("RemoteRepository", " SYNS ${synsData.value}")
            }
        } catch (e: Exception) {
            Log.d("RemoteRepository", "error SYNS ${e}")
        }
        return synsData
    }

    override fun close() {
        job.cancel()
    }
}