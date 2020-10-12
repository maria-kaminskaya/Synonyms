package com.kmnvxh222.synonyms

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.kmnvxh222.synonyms.repository.remote.RemoteRepository

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        Log.d("MainActivity",RemoteRepository().getDataForms().toString())
//        RemoteRepository().getDataForms()

//        Log.d("MainActivity",RemoteRepository().getDataRoot().toString())
        Log.d("MainActivity", RemoteRepository().getDataSyns().toString())
    }
}