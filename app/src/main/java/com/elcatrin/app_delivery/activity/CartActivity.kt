package com.elcatrin.app_delivery.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.elcatrin.app_delivery.R
import com.elcatrin.app_delivery.adapter.CartProductAdapter
import com.elcatrin.app_delivery.model.Order
import com.elcatrin.app_delivery.viewModel.CartViewModel
import kotlinx.android.synthetic.main.activity_cart.*
import kotlinx.android.synthetic.main.activity_home.*
import java.io.Serializable

class CartActivity : AppCompatActivity(), Serializable {
    private lateinit var productAdapter: CartProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        setupRecycler()
        setListeners()
    }

    private fun setListeners() {
        place_order_button.setOnClickListener {
            val billingActivity: Intent = Intent(this, BillingActivity::class.java).apply { }
            CartViewModel.createOrder()
            startActivity(billingActivity)
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

    fun onShoppingCartClick(mi: MenuItem?) {
        val cartActivity: Intent = Intent(this, CartActivity::class.java).apply { }
        startActivity(cartActivity)
    }

    fun onCurrentLocation(mi: MenuItem?) {
        val currentLocationOnMap: Intent = Intent(this, CurrentLocationOnMap::class.java).apply { }
        startActivity(currentLocationOnMap)
    }

    /*
    fun onOrderList(mi: MenuItem?) {
        val orderList: Intent = Intent(this, ProductDetailActivity::class.java).apply { }
        startActivity(orderList)
    }
*/

}