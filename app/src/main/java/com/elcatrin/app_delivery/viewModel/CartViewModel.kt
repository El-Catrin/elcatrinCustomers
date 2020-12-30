package com.elcatrin.app_delivery.viewModel

import android.util.Log
import com.elcatrin.app_delivery.model.Product

class CartViewModel {

    private fun removeProduct(product: Product) {
        productList.remove(product)
    }

    private fun placeOrder() {
        // save on Firebase
    }

    companion object {
        private var productList: MutableList<Product> = mutableListOf<Product>()

        fun addProduct(product: Product) {
            productList.add(product)
            Log.d("ADD", "${product.name} added")
        }

        fun placeOrder() {
        }
    }
}