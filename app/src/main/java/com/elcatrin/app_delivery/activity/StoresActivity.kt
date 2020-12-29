package com.elcatrin.app_delivery.activity

import android.os.Bundle
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
            adapter.setListData(it)
            adapter.notifyDataSetChanged()
        })
    }
}