package com.elcatrin.app_delivery.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders


import androidx.recyclerview.widget.LinearLayoutManager
import com.elcatrin.app_delivery.ProductoAdapter
import com.elcatrin.app_delivery.Productos
import com.elcatrin.app_delivery.R
import com.elcatrin.app_delivery.viewmodel.MainViewProductos
import kotlinx.android.synthetic.main.activity_catalogo_productos.*

class CatalogoProductos : AppCompatActivity(){

    private lateinit var adapter: ProductoAdapter
    private val  viewModel by lazy{ ViewModelProviders.of(this).get(MainViewProductos::class.java)}

    // funcion para desplegar activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalogo_productos)

        adapter= ProductoAdapter(this)

        // instanciar recycley
        recyclerProductos.layoutManager= LinearLayoutManager(this)
        recyclerProductos.adapter = adapter
        observeData()
    }

    fun observeData(){
        viewModel.fetchUserData().observe(this, Observer {
            adapter.setLisData(it)
            adapter.notifyDataSetChanged()
        })
    }



}