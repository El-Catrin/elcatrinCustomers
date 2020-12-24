package com.elcatrin.app_delivery.model

data class Order(
    val productId: String,
    val quantity: String,
    val price: String,
    val discount: String
)