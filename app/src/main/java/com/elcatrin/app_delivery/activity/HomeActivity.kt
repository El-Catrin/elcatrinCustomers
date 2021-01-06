package com.elcatrin.app_delivery.activity

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.elcatrin.app_delivery.R
import com.elcatrin.app_delivery.viewModel.CartViewModel
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : AppCompatActivity() {
    var cartViewModel = CartViewModel()

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        configureToolBar()
        setListeners()
        Log.d("APP STATUS", "Started")
    }

    private fun setListeners() {
        img_btn_empresas.setOnClickListener {
            val storesActivity: Intent = Intent(this, StoresActivity::class.java).apply { }
            startActivity(storesActivity)
        }

//        img_btn_empresas.setOnClickListener {
//
//            // start cart activity
//        }
        // add button for cart access temporarily
    }

    private fun configureToolBar() {
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
    }

    fun onShoppingCartClick(mi: MenuItem?) {
        val cartActivity: Intent = Intent(this, CartActivity::class.java).apply { }
        startActivity(cartActivity)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }
}
