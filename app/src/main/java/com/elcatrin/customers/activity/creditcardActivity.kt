package com.elcatrin.customers.activity

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.elcatrin.customers.R

class creditcardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_credit_card)
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

    fun onOrderListClick(mi: MenuItem?) {
        val ordersActivity: Intent = Intent(this, OrdersActivity::class.java).apply { }
        startActivity(ordersActivity)
    }
}