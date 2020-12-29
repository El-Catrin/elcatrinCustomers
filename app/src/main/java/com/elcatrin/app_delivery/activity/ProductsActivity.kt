package com.elcatrin.app_delivery.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.elcatrin.app_delivery.R
import com.elcatrin.app_delivery.adapter.ProductAdapter
import com.elcatrin.app_delivery.viewModel.ProductViewModel
import kotlinx.android.synthetic.main.activity_catalogo_productos.*

class ProductsActivity : AppCompatActivity() {

    private lateinit var adapter: ProductAdapter
    private val productViewModel by lazy { ViewModelProviders.of(this).get(ProductViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalogo_productos)

        adapter = ProductAdapter(this)
        recyclerProductos.layoutManager = LinearLayoutManager(this)
        recyclerProductos.adapter = adapter

        var storeId = intent.getStringExtra("storeId")
        getProductsByStoreId(storeId)
    }

    private fun getProductsByStoreId(storeId: String?) {
        productViewModel.getProductsByStoreId(storeId).observe(this, Observer {
            adapter.setLisData(it)
            adapter.notifyDataSetChanged()
        })
    }
}