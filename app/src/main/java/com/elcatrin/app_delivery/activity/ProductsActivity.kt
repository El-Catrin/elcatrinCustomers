package com.elcatrin.app_delivery.activity

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
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
    private val productViewModel by lazy {
        ViewModelProviders.of(this).get(ProductViewModel::class.java)
    }

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
            adapter.setListData(it)
            adapter.notifyDataSetChanged()
        })
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