package com.elcatrin.app_delivery.model

data class ProductInOrder(
    val id: String = "000",
    val storeId: String = "00",
    val cant: String= "0",
    val product_name :String= "",
    val price: Double = 0.0

)