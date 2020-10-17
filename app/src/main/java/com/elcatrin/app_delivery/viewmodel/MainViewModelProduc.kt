package com.elcatrin.app_delivery.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.elcatrin.app_delivery.Productos
import com.elcatrin.app_delivery.domain.data.network.RepoProductos

class MainViewModelProduc: ViewModel() {
    private val repo = RepoProductos()

    fun fetchProductosData(): LiveData<MutableList<Productos>> {
        val mutableData2 = MutableLiveData<MutableList<Productos>>()
        repo.getProductosData().observeForever { productosList ->
            mutableData2.value = productosList
        }
        return mutableData2
    }
}