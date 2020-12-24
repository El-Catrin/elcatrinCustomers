package com.elcatrin.app_delivery.model

import java.util.*

data class Product(
    val name: String,
    val image: String,
    val price: String,
    val category: String,
    val delivery_time: Date,
    val description: String
)