package com.elcatrin.customers.model

data class ProductInOrder(
    val id: String = "000",
    val storeId : String = "000",
    val cant: String= "000",
    val product_name :String= "",
    val price: Double = 0.0
)