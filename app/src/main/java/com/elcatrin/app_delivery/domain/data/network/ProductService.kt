package com.elcatrin.app_delivery.domain.data.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.elcatrin.app_delivery.model.Product
import com.google.firebase.firestore.FirebaseFirestore

class ProductService {

    fun getProductByStoreId(storeId: String): LiveData<MutableList<Product>> {

        val products = MutableLiveData<MutableList<Product>>()
        FirebaseFirestore.getInstance().collection("Catalog_Products")
            .whereEqualTo("Cod_Company", storeId)
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
                    val productsList = Product(imagen!!, nombre!!, descuento!!, precio!!, codigo!!)
                    listData.add(productsList)

                }
                products.value = listData
            }

        return products
    }
}



