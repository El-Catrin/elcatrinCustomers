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

        fun getShoppingList(): MutableList<Product> {
            return productList
        }

        fun addProduct(product: Product) {
            productList.add(product)
            Log.d("ADD", "${product.name} added")
        }

        fun getTotal(): Double {
            var total = 0.0

            for(product in productList){
                total += product.price.toDouble()
            }
            return total
        }

        fun placeOrder() {
        }
    }
}