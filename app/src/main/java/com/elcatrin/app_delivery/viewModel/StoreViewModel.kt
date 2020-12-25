package com.elcatrin.app_delivery.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.elcatrin.app_delivery.domain.data.network.StoreService
import com.elcatrin.app_delivery.model.Store

class StoreViewModel : ViewModel() {
    private val repository = StoreService()

    fun fetchStoreDetails(): LiveData<MutableList<Store>> {
        val mutableData = MutableLiveData<MutableList<Store>>()
        repository.getEmpresaData().observeForever { stores ->
            mutableData.value = stores
        }

        return mutableData
    }
}