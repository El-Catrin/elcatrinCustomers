package com.elcatrin.app_delivery.model

data class Order(
    val userId: String,
    val storeId: String,
    val direction: String,
    val deliveryCost: Double,
    val deliveryTime: String,
    val products: Map<String, Double>
)