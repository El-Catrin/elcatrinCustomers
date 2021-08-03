package com.elcatrin.customers.viewModel

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.elcatrin.customers.activity.CurrentLocationOnMap
import com.elcatrin.customers.activity.cashpaymentActivity
import com.elcatrin.customers.domain.data.network.OrderService
import com.elcatrin.customers.model.Order
import com.elcatrin.customers.model.Product
import com.elcatrin.customers.model.ProductInOrder
import com.google.firebase.auth.FirebaseAuth
import java.time.LocalDate
import java.time.LocalTime

class CartViewModel {

    companion object {
        private val orderService = OrderService()
        private var productList = mutableListOf<Product>()
        private var order = Order()
        private  val uid = FirebaseAuth.getInstance().currentUser?.uid
        private val loc = CurrentLocationOnMap().currentLocation
        private val change = cashpaymentActivity()

        fun getShoppingList(): MutableList<Product> {
            return productList
        }

        fun addProduct(product: Product) {
            productList.add(product)
            Log.d("ADD", "${product.name} added")
        }

        @RequiresApi(Build.VERSION_CODES.O)
        fun createOrder() {
            val products = mutableListOf<ProductInOrder>()
            val currentDate = LocalDate.now()
            val currentHour = LocalTime.now()
            var subtotal = 0.0
            for (p in productList) {
                products.add(ProductInOrder(p.id,p.storeId,p.cant,p.name,p.price))
                subtotal += p.price
            }

            this.order = Order(
                uid.toString(),
                "01",
                loc.toString(),
                subtotal,
                0.0,
                50.0,
                0.0,
                "30m",
                "",
                currentDate.toString(),
                currentHour.toString(),
                "En Espera",
                products
            )

            Log.d("Order Created", order.delivery_Cost.toString())
        }

        fun getOrder(): Order {
            return this.order
        }

        fun saveOrder(order: Order) {
            orderService.saveOrder(order)
        }
    }
}