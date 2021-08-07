package com.elcatrin.app_delivery.activity

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.elcatrin.app_delivery.R
import com.elcatrin.app_delivery.adapter.CartProductAdapter
import com.elcatrin.app_delivery.viewModel.CartViewModel
import kotlinx.android.synthetic.main.activity_billing.*
import kotlinx.android.synthetic.main.activity_cart.*
import kotlinx.android.synthetic.main.activity_cart.place_order_button
import java.io.Serializable

class CartActivity : AppCompatActivity(), Serializable {
    private lateinit var productAdapter: CartProductAdapter

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        setupRecycler()
        setListeners()
    }


    @RequiresApi(Build.VERSION_CODES.O)
    private fun setListeners() {
        place_order_button.setOnClickListener {
            var shoppingList = CartViewModel.getShoppingList()
            if (shoppingList.isNotEmpty()) {
                val methodPayment: Intent = Intent(this, methodPayment::class.java).apply { }
                CartViewModel.createOrder()
                startActivity(methodPayment)
            }else{
                Toast.makeText(this, "Carrito de compras se encuentra vacío", Toast.LENGTH_LONG).show()
            }
            }
    }
    
    private fun setupRecycler() {
        var shoppingList = CartViewModel.getShoppingList()

        productAdapter = CartProductAdapter(this)
        productAdapter.setListData(shoppingList)

        recyclerCart.layoutManager = LinearLayoutManager(this)
        recyclerCart.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        recyclerCart.adapter = productAdapter
    }

    fun onHomePageClick(mi: MenuItem?) {
        val HomeActivity: Intent = Intent(this, HomeActivity::class.java).apply { }
        startActivity(HomeActivity)
    }



    fun onOrderListClick(mi: MenuItem?) {
        val ordersActivity: Intent = Intent(this, OrdersActivity::class.java).apply { }
        startActivity(ordersActivity)
    }

}