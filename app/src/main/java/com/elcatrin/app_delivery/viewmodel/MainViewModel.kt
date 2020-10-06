package com.elcatrin.app_delivery.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.elcatrin.app_delivery.Empresa
import com.elcatrin.app_delivery.domain.data.network.Repo
import com.elcatrin.app_delivery.Productos

class MainViewModel: ViewModel() {
    private val repo = Repo()

    fun fetchEmpresaData():LiveData<MutableList<Empresa>>{
        val mutableData = MutableLiveData<MutableList<Empresa>>()
        repo.getEmpresaData().observeForever { empresaList ->
            mutableData.value = empresaList
        }
        return mutableData
    }

    fun fetchProductosData():LiveData<MutableList<Productos>>{
        val mutableData2 = MutableLiveData<MutableList<Productos>>()
        repo.getProductosData().observeForever { productosList ->
            mutableData2.value = productosList
        }
        return mutableData2
    }

}