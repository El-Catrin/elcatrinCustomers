package com.elcatrin.app_delivery.model

data class Product(
    val id: String = "000",
    val storeId: String = "000",
    val cant: String = "00",
    val name: String = "name",
    val price: Double = 0.0,
    val image: String = "image",
    val description: String = "description"
)