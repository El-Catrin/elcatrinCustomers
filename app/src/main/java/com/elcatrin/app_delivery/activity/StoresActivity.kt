package com.elcatrin.app_delivery.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.elcatrin.app_delivery.R
import com.elcatrin.app_delivery.adapter.MainAdapter
import com.elcatrin.app_delivery.util.StoreRepository
import kotlinx.android.synthetic.main.activity_catalogo_empresas.*

class StoresActivity : AppCompatActivity() {
    private lateinit var adapter: MainAdapter
    private val viewModel by lazy { ViewModelProvider(this).get(StoreRepository::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalogo_empresas)

        adapter = MainAdapter(this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        recyclerView.adapter = adapter

        observeData()
    }

    fun observeData() {
        viewModel.fetchStoreDetails().observe(this, Observer {
            adapter.setListData(it)
            adapter.notifyDataSetChanged()
        })
    }
}