package com.elcatrin.app_delivery.model

data class Order(
    val userId: String,
    val storeId: String,
    val direction: String,
    val subtotal: Double,
    val deliveryCost: Double,
    val deliveryTime: String,
    val Driver_ID : String,
    val order_Status : String,
    val RTN:String,
    val purcharse_Date : String,
    val purcharse_Hour : String,
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