package com.elcatrin.app_delivery.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.elcatrin.app_delivery.Empresa

class MainViewModel: ViewModel() {
    fun fetchEmpresaData():LiveData<MutableList<Empresa>>{
        val mutableData = MutableLiveData<MutableList<Empresa>>()
    }
}