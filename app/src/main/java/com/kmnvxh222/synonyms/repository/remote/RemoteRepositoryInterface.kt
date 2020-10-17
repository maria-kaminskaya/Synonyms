package com.kmnvxh222.synonyms.repository.remote

import androidx.lifecycle.MutableLiveData
import com.kmnvxh222.synonyms.model.remote.Forms
import com.kmnvxh222.synonyms.model.remote.Root
import com.kmnvxh222.synonyms.model.remote.Syn

interface RemoteRepositoryInterface {
//    fun getDataForms(query: String): MutableLiveData<Forms?>
//    fun getDataRoot(query: String): MutableLiveData<Root?>
    fun getDataSyns(query: String): MutableLiveData<Syn?>
}