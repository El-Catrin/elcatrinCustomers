package com.elcatrin.customers.model

import com.google.firebase.Timestamp
import com.google.firebase.firestore.GeoPoint

data class Order(
    val user_Id: String,
    val driver_Id: String,
    val direction: String,
    val subtotal: Double,
    val total: Double,
    val delivery_Cost: Double,
    val cash_Change :Double,
    val delivery_Time: String,
    val RTN: String,
    val purchase_Date: String,
    val purchase_Hour: String,
    val order_Status: String,
    val products: MutableList<ProductInOrder>
) {
    constructor() : this(
        "",
        "",
        "",
        0.0,
        0.0,
        0.0,
        0.0,
        "",
        "",
        "",
        "",
        "",
        mutableListOf(ProductInOrder())
    )
}