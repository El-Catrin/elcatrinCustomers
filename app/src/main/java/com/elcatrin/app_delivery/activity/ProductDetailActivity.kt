package com.elcatrin.app_delivery.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.elcatrin.app_delivery.R
import com.elcatrin.app_delivery.ViewModel.ProductViewModel
import kotlinx.android.synthetic.main.activity_product_detail.*

class ProductDetailActivity : AppCompatActivity() {
    private val productViewModel by lazy { ViewModelProvider(this).get(ProductViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        val productId = intent.getStringExtra("productId")
        getProductById(productId)
    }

    private fun getProductById(productId: String?) {
        productViewModel.getProductById(productId).observe(this, Observer {
            for (row in it) {
                nombreProducto.text = row.name
                precioProducto.text = row.price
                descripcionProducto.text = row.description
                Glide.with(this).load(row.image).into(imageProducto)
            }
        })
    }
}
