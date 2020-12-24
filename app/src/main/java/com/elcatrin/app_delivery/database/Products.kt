package com.elcatrin.app_delivery.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.elcatrin.app_delivery.model.Product
import com.google.firebase.firestore.FirebaseFirestore

class Products {

    fun getUserData(): LiveData<MutableList<Product>> {

        val mutableData = MutableLiveData<MutableList<Product>>()
        FirebaseFirestore.getInstance().collection("Catalog_Products")
            .whereEqualTo("Cod_Company", "06")
            .get()
            .addOnSuccessListener { result ->
                val listData: MutableList<Product> = mutableListOf<Product>()
                for (document in result) {
                    val imagen = document.getString("Product_Image")
                    val nombre = document.getString("Product_Name")
                    val descuento = document.getString("Product_Desc")
                    val precio = document.getString("Product_Price")
                    val codigo = document.getString("Cod_Company")
                    //val codigo_productos = document.getString("Cod_Products")
                    val productos = Product(imagen!!, nombre!!, descuento!!, precio!!, codigo!!)
                    listData.add(productos)

                }
                mutableData.value = listData
            }
        return mutableData
    }
}



