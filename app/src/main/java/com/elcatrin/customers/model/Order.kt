package com.elcatrin.customers.model

import com.google.firebase.Timestamp
import com.google.firebase.firestore.GeoPoint

data class Order(
    val userId: String,
    val storeId: String,
    val direction: String,
    val subtotal: Double,
    val deliveryCost: Double,
    val deliveryTime: String,
    val Driver_ID : String,
    val Order_Status : String,
    val RTN:String,
    val Purcharse_Date : String,
    val Purcharse_Hour : String,
    val Total: String,
    val products: MutableList<ProductInOrder>
) {
    constructor() : this(
        "",
        "",
        "",
        0.0,
        0.0,
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        mutableListOf(ProductInOrder())

    )
}