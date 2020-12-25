package com.elcatrin.app_delivery.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.elcatrin.app_delivery.R
import com.elcatrin.app_delivery.model.Product
import com.elcatrin.app_delivery.viewModel.ProductViewModel
import kotlinx.android.synthetic.main.activity_product_detail.*

class ProductDetailActivity : AppCompatActivity() {
    private val productViewModel by lazy { ViewModelProvider(this).get(ProductViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        val productId = intent.getStringExtra("productId")
        var product = productViewModel.getProductById(productId)

        observeData(product)
    }

    fun observeData(product: Product) {
        nombreProducto.text = product.name
        precioProducto.text = product.price
        descripcionProducto.text = product.description
        Glide.with(this).load(product.image).into(imageProducto)
    }
}
