package com.elcatrin.app_delivery.viewModel

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.elcatrin.app_delivery.activity.CurrentLocationOnMap
import com.elcatrin.app_delivery.activity.ProductDetailActivity
import com.elcatrin.app_delivery.domain.data.network.OrderService
import com.elcatrin.app_delivery.model.Order
import com.elcatrin.app_delivery.model.Product
import com.elcatrin.app_delivery.model.ProductInOrder
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_product_detail.*
import java.time.LocalDate
import java.time.LocalTime
import kotlinx.android.synthetic.main.activity_product_detail.*

class CartViewModel {

    companion object {
        private val orderService = OrderService()
        private var productList = mutableListOf<Product>()
       private val cantidad = ""
        private var order = Order()
        private  val uid = FirebaseAuth.getInstance().currentUser?.uid
        private val loc = CurrentLocationOnMap().currentLocation
        @RequiresApi(Build.VERSION_CODES.O)
        private val date = LocalDate.now()
        @RequiresApi(Build.VERSION_CODES.O)
        private val hour = LocalTime.now()

        fun getShoppingList(): MutableList<Product> {
            return productList
        }

        fun addProduct(product: Product) {
            productList.add(product)
            Log.d("ADD", "${product.name} added")
        }

        fun getCant(cant:String): String
        {
            return cantidad
        }

        @RequiresApi(Build.VERSION_CODES.O)
        fun createOrder() {
            val products = mutableListOf<ProductInOrder>()
            var subtotal = 0.0
            for (p in productList) {
                products.add(ProductInOrder(p.id,p.storeId,cantidad,p.name,p.price))
                subtotal += p.price

            }

            this.order = Order(
                uid.toString(),
                "01",
                "14.063796, -87.173540",
                subtotal,
                50.0,
                "30m",
                "01",
                "En Espera",
                "",
                date.toString(),
                hour.toString(),
                "",
                products
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