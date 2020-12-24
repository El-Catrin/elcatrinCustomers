package com.elcatrin.app_delivery.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.elcatrin.app_delivery.model.Store
import com.google.firebase.firestore.FirebaseFirestore

class Stores {
    fun getEmpresaData(): LiveData<MutableList<Store>> {
        val mutableData = MutableLiveData<MutableList<Store>>()
        FirebaseFirestore.getInstance().collection("Catalog_Company").get()
            .addOnSuccessListener { result ->
                val listData = mutableListOf<Store>()
                for (document in result) {
                    val codigo = document.getString("Cod_Company")
                    val logo = document.getString("Logo_Company")
                    val nombre = document.getString("Name_Company")
                    val descripcion = document.getString("Desc_Company")
                    val banner = document.getString("Company_Banner")
                    val horario = document.getString("Working_Hours")
                    val min_cost = document.getString("Min_Cost")
                    val empresa = Store(
                        codigo!!,
                        logo!!,
                        nombre!!,
                        descripcion!!,
                        banner!!,
                        horario!!,
                        min_cost!!
                    )
                    listData.add(empresa)
                }
                mutableData.value = listData
            }
        return mutableData
    }
}