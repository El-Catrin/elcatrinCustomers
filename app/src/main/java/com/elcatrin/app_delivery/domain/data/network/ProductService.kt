package com.elcatrin.app_delivery.domain.data.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.elcatrin.app_delivery.model.Product
import com.google.firebase.firestore.FirebaseFirestore

class ProductService {

    fun getProductByStoreId(storeId: String?): LiveData<MutableList<Product>> {
        val products = MutableLiveData<MutableList<Product>>()

        FirebaseFirestore.getInstance().collection("Catalog_Products")
            .whereEqualTo("Cod_Company", storeId)
            .get()
            .addOnSuccessListener { result ->
                val listData: MutableList<Product> = mutableListOf<Product>()
                for (row in result) {
                    val id = row.getString("Cod_Product")
                    val name = row.getString("Product_Name")
                    val price = row.getDouble("Product_Price")
                    val picture = row.getString("Product_Image")
                    val description = row.getString("Product_Desc")

                    val product =
                        Product(id!!, storeId!!, "", name!!, price!!, picture!!, description!!)

                    listData.add(product)
                }

                products.value = listData
            }

        return products
    }

    fun getProductById(productId: String?): LiveData<MutableList<Product>> {
        val products = MutableLiveData<MutableList<Product>>()

        FirebaseFirestore.getInstance().collection("Catalog_Products")
            .whereEqualTo("Cod_Product", productId)
            .get()
            .addOnSuccessListener { result ->
                val listData = mutableListOf<Product>()
                val p = result.elementAt(0)

                val id = p.getString("Cod_Product")
                val storeId = p.getString("Cod_Company")
                val name = p.getString("Product_Name")
                val price = p.getDouble("Product_Price")
                val picture = p.getString("Product_Image")
                val description = p.getString("Product_Desc")

                val product = Product(id!!, storeId!!, "", name!!, price!!, picture!!, description!!)
                listData.add(product)
                products.value = listData
            }

        return products
    }
}



