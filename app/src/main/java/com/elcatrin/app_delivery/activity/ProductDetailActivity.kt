package com.elcatrin.app_delivery.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.elcatrin.app_delivery.R
import com.elcatrin.app_delivery.model.Product
import com.elcatrin.app_delivery.viewModel.CartViewModel
import com.elcatrin.app_delivery.viewModel.ProductViewModel
import kotlinx.android.synthetic.main.activity_product_detail.*

class ProductDetailActivity : AppCompatActivity() {
    private val productViewModel by lazy { ViewModelProvider(this).get(ProductViewModel::class.java) }
    private var product = Product()
    var productList: MutableList<Product> = mutableListOf<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        val productId = intent.getStringExtra("productId")
        getProductById(productId)

        setListeners()

    }

    private fun getProductById(productId: String?) {
        productViewModel.getProductById(productId).observe(this, Observer {
            var p = it[0]
            product = p
            nombreProducto.text = product.name
            precioProducto.text = product.price
            descripcionProducto.text = product.description
            Glide.with(this).load(product.image).into(imageProducto)
        })
    }

    private fun setListeners() {
        btnComprar.setOnClickListener {
            CartViewModel.addProduct(product)
        }
    }
}