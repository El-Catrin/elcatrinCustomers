package com.elcatrin.app_delivery.activity

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.elcatrin.app_delivery.R
import com.elcatrin.app_delivery.adapter.StoreAdapter
import com.elcatrin.app_delivery.viewModel.StoreViewModel
import kotlinx.android.synthetic.main.activity_catalogo_empresas.*

class StoresActivity : AppCompatActivity() {
    private lateinit var adapter: StoreAdapter
    private val storeViewModel by lazy { ViewModelProvider(this).get(StoreViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalogo_empresas)

        adapter = StoreAdapter(this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        recyclerView.adapter = adapter

        observeData()
    }

    private fun observeData() {
        storeViewModel.getStores().observe(this, Observer {
            adapter.setStores(it)
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