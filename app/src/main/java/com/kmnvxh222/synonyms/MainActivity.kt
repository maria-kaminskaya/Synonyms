package com.kmnvxh222.synonyms

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.kmnvxh222.synonyms.model.Response
import com.kmnvxh222.synonyms.network.apiclient.RetrofitApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val observable  =  RetrofitApi.retrofitApiService.getForms("кот")

        observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { response ->
                    Log.d("MainActivity", "FORMS ${response.response?.one}")
                },
                { error ->
                    Log.d("MainActivity", "error ${error}")
                }
            )

//        val observable1  =  RetrofitApi.retrofitApiService.getRoot("кот")
//        observable1.subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(
//                { response ->
//                    Log.d("MainActivity", "ROOT ${response.response!!.root[0]}")
//                },
//                { error ->
//                    Log.d("MainActivity", "error ${error}")
//                }
//            )
//
//        val observable2  =  RetrofitApi.retrofitApiService.getSyns("кот")
//        observable2.subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(
//                { response ->
//                    Log.d("MainActivity", "SYNS ${response.response!!.syns[0]}")
//                },
//                { error ->
//                    Log.d("MainActivity", "error ${error}")
//                }
//            )
    }
}