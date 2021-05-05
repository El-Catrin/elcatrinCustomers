package com.elcatrin.app_delivery.viewModel

import android.util.Log
import com.elcatrin.app_delivery.activity.CurrentLocationOnMap
import com.elcatrin.app_delivery.domain.data.network.OrderService
import com.elcatrin.app_delivery.model.Order
import com.elcatrin.app_delivery.model.Product
import com.elcatrin.app_delivery.model.ProductInOrder
import com.google.firebase.auth.FirebaseAuth

class CartViewModel {

    companion object {
        private val orderService = OrderService()
        private var productList = mutableListOf<Product>()
        private var order = Order()
        private  val uid = FirebaseAuth.getInstance().currentUser?.uid
        private val loc = CurrentLocationOnMap().currentLocation


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
                uid.toString(), "storeId", "Mi Ubicación",
                subtotal, 50.0, "30m", products
            )

            Log.d("Order Created", order.deliveryCost.toString())
        }

        fun getOrder(): Order {
            return this.order
        }

        fun saveOrder(order: Order) {
            orderService.saveOrder(order)
        }
    }
}