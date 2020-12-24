package com.elcatrin.app_delivery.util

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.elcatrin.app_delivery.database.Stores
import com.elcatrin.app_delivery.model.Store

class StoreRepository : ViewModel() {
    private val repository = Stores()

    fun fetchStoreDetails(): LiveData<MutableList<Store>> {
        val mutableData = MutableLiveData<MutableList<Store>>()
        repository.getEmpresaData().observeForever { stores ->
            mutableData.value = stores
        }

        return mutableData
    }
}