package com.kmnvxh222.synonyms.repository.remote

import com.kmnvxh222.synonyms.model.remote.Forms
import com.kmnvxh222.synonyms.model.remote.Root
import com.kmnvxh222.synonyms.model.remote.Syn

interface RemoteRepositoryInterface {
    fun getDataForms(query: String): Forms?
    fun getDataRoot(query: String): Root?
    fun getDataSyns(query: String): Syn?
}