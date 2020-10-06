package com.elcatrin.app_delivery.domain.data.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.elcatrin.app_delivery.Empresa
import com.elcatrin.app_delivery.Productos
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

    fun getProductosData():LiveData<MutableList<Productos>>{
        val mutableData2 = MutableLiveData<MutableList<Productos>>()
        FirebaseFirestore.getInstance().collection("Catalog_Products").get().addOnSuccessListener { result ->
            val listData2 = mutableListOf<Productos>()
            for (document in result){
                val descripcion = document.getString("Product_Desc")
                val imagen = document.getString("Product_Image")
                val nombre = document.getString("Product_Name")
                val precio = document.getString("Product_Price")
                val producto = Productos(descripcion!!,imagen!!,nombre!!,precio!!)
                listData2.add(producto)
            }
            mutableData2.value = listData2
        }
        return mutableData2
    }

}