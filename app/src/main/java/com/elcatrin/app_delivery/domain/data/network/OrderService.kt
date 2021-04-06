package com.elcatrin.app_delivery.domain.data.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.elcatrin.app_delivery.model.Order
import com.google.firebase.firestore.FirebaseFirestore

class OrderService {
    fun getOrdersByUserId(id: String): LiveData<MutableList<Order>> {
        val orders = MutableLiveData<MutableList<Order>>()

        FirebaseFirestore.getInstance().collection("Purchase_Order")
            .whereEqualTo("userId", id)
            .limit(10)
            .get()
            .addOnSuccessListener { result ->
                val list = mutableListOf<Order>()
                for (document in result) {
                    val order = document.toObject(Order::class.java)
                    list.add(order)
                }
                orders.value = list
            }
            .addOnFailureListener {
                Log.d("EXCEPTION:", it.toString())
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