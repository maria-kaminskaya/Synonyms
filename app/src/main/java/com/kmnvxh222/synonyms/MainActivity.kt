package com.kmnvxh222.synonyms

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.kmnvxh222.synonyms.repository.remote.RemoteRepositoryImpl

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}