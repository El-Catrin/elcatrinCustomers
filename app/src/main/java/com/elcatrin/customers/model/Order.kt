package com.elcatrin.customers.model

data class Order(
    val userId: String,
    val storeId: String,
    val direction: String,
    val subtotal: Double,
    val deliveryCost: Double,
    val deliveryTime: String,
    val products: MutableList<ProductInOrder>
) {
    constructor() : this(
        "",
        "", "",
        0.0,
        0.0,
        "",
        mutableListOf(ProductInOrder())
    )
}