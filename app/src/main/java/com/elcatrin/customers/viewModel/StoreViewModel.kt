package com.elcatrin.customers.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.elcatrin.customers.domain.data.network.StoreService
import com.elcatrin.customers.model.Store

class StoreViewModel : ViewModel() {
    private val storeService = StoreService()

    fun getStores(): LiveData<MutableList<Store>> {
        val mutableData = MutableLiveData<MutableList<Store>>()
        storeService.getStores().observeForever { stores ->
            mutableData.value = stores
        }

        return mutableData
    }
}