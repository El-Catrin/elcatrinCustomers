package com.elcatrin.app_delivery.domain.data.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.elcatrin.app_delivery.Empresa
import com.google.firebase.firestore.FirebaseFirestore

class Repo {
    fun getEmpresaData():LiveData<MutableList<Empresa>>{
        val mutableData = MutableLiveData<MutableList<Empresa>>()
        FirebaseFirestore.getInstance().collection("Catalog_Company").get().addOnSuccessListener { result ->
            val listData = mutableListOf<Empresa>()
            for (document in result){
                val logo = document.getString("Logo_Company")
                val nombre = document.getString("Name_Company")
                val descripcion = document.getString("Desc_Company")
                val horario = document.getString("Working_Hours")
                val min_cost = document.getString("Min_Cost")
                val empresa = Empresa(logo!!,nombre!!,descripcion!!,horario!!,min_cost!!)
                listData.add(empresa)
            }
            mutableData.value = listData
        }
        return mutableData
    }
}