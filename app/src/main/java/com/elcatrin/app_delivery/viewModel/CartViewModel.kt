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

        fun createOrder() {
            val products = mutableListOf<ProductInOrder>()
            var subtotal = 0.0
            for (p in productList) {
                products.add(ProductInOrder(p.id, p.price))
                subtotal += p.price
            }

            this.order = Order(
                "userId", "storeId", "direction",
                subtotal, 100.0, "1h", products
            )

            Log.d("Order Created", order.deliveryCost.toString())
        }

        fun getOrder(): Order {
            return this.order
        }

        fun saveOrder() {

        }
    }
}