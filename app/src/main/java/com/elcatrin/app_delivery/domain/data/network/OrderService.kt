package com.elcatrin.app_delivery.domain.data.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.elcatrin.app_delivery.model.Order
import com.elcatrin.app_delivery.model.ProductInOrder
import com.google.firebase.firestore.FirebaseFirestore

class OrderService {
    fun getOrdersByUserId(id: String): LiveData<MutableList<Order>> {
        val orders = MutableLiveData<MutableList<Order>>()
        val products = mutableListOf<ProductInOrder>()
        FirebaseFirestore.getInstance().collection("Purchase_Order")
            .whereEqualTo("User_Id", id)
            .get()
            .addOnSuccessListener { result ->
                val list = mutableListOf<Order>()
                for (document in result) {
                    val userId = document.getString("User_Id")
                    val storeId = document.getString("Cod_Company")
                    val direction = document.getString("Direction")
                    val subtotal = document.getDouble("Subtotal")
                    val deliveryCost = document.getDouble("Delivery_Cost")
                    val deliveryTime = document.getString("Delivery_Time")
//                    val products = document.get("Products")
                    val order = Order(
                        userId!!,
                        storeId!!,
                        direction!!,
                        subtotal!!,
                        deliveryCost!!,
                        deliveryTime!!,
                        products
                    )
                    list.add(order)
                }
                orders.value = list
            }

        return orders
    }

    fun saveOrder(order: Order) {
        FirebaseFirestore.getInstance().collection("Purchase_Order")
            .add(order)
            .addOnSuccessListener {
                Log.d("ORDER:", "Saved Order with ID: ${it.id}")
            }
            .addOnFailureListener {
                Log.d("ORDER:", "Error saving an order")
            }
    }
}