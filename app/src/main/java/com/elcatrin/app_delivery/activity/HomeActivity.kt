package com.elcatrin.app_delivery.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.elcatrin.app_delivery.R
import com.elcatrin.app_delivery.model.Product
import com.elcatrin.app_delivery.viewModel.CartViewModel
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    var cartViewModel = CartViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setListeners()
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
}
