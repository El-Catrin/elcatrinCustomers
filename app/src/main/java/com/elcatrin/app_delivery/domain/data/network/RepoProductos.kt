package com.elcatrin.app_delivery.domain.data.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.elcatrin.app_delivery.Productos
import com.google.firebase.firestore.FirebaseFirestore

class RepoProductos {
    fun getProductosData(): LiveData<MutableList<Productos>> {
        val mutableData2 = MutableLiveData<MutableList<Productos>>()
        FirebaseFirestore.getInstance().collection("Catalog_Products").get().addOnSuccessListener { resultPro ->
            val listData2 = mutableListOf<Productos>()
            for (document in resultPro){
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