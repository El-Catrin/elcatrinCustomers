package com.elcatrin.app_delivery.viewModel

import android.util.Log
import com.elcatrin.app_delivery.model.Order
import com.elcatrin.app_delivery.model.Product
import com.elcatrin.app_delivery.model.ProductInOrder

class CartViewModel {

    companion object {
        private var productList = mutableListOf<Product>()
        private var order = Order()

        fun getShoppingList(): MutableList<Product> {
            return productList
        }

        fun addProduct(product: Product) {
            productList.add(product)
            Log.d("ADD", "${product.name} added")
        }

        fun getTotal(): Double {
            var total = 0.0

            for (product in productList) {
                total += product.price
            }
            return total
        }

        fun createOrder() {
            val products = mutableListOf<ProductInOrder>()
            for (p in productList) {
                products.add(ProductInOrder(p.id, p.price))
            }

            this.order = Order("userId", "storeId", "direction", this.getTotal(), "1h", products
            )

            Log.d("Order Created", order.deliveryCost.toString())
        }

        fun getOrder(): Order {
            return this.order
        }
    }
}