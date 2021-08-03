package com.elcatrin.customers.activity

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.elcatrin.customers.R
import com.elcatrin.customers.adapter.StoreAdapter
import com.elcatrin.customers.viewModel.StoreViewModel
import kotlinx.android.synthetic.main.activity_catalogo_empresas.*

class StoresActivity : AppCompatActivity() {
    private lateinit var adapter: StoreAdapter
    private val storeViewModel by lazy { ViewModelProvider(this).get(StoreViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalogo_empresas)

        adapter = StoreAdapter(this)
        recyclerCommerce.layoutManager = LinearLayoutManager(this)
        recyclerCommerce.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        recyclerCommerce.adapter = adapter

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


    fun onOrderListClick(mi: MenuItem?) {
        val ordersActivity: Intent = Intent(this, OrdersActivity::class.java).apply { }
        startActivity(ordersActivity)
    }
}