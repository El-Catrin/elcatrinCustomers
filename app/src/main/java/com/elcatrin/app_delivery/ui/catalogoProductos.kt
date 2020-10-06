package com.elcatrin.app_delivery.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.elcatrin.app_delivery.MainAdapterProductos
import com.elcatrin.app_delivery.viewmodel.MainViewModel
import com.elcatrin.app_delivery.R
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_catalogo_productos.*

class catalogoProductos : AppCompatActivity() {

    // Access a Cloud Firestore instance from your Activity
    val db = FirebaseFirestore.getInstance()

    //Al declararlo como lateinit var debo inicializarlo antes de usarlo
    private lateinit var adapter: MainAdapterProductos
    //Al declararlo con lazy se inicializa cuando lo necesito, o sea automáticamente
    //private val viewModel by lazy { ViewModelProviders.of(this).get(MainViewModel::class.java) }
    private val viewModel by lazy { ViewModelProvider(this).get(MainViewModel::class.java) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalogo_productos)

        //Inicializo el adapter que declare arriba
        adapter = MainAdapterProductos(this)
        //Inicialización del recyclerView
        recyclerViewProductos.layoutManager = LinearLayoutManager(this)
        recyclerViewProductos.adapter = adapter
        //Método
        observeData()

        //Función Catálogo Empresas
        //cat_Empresas()
    }

    fun observeData(){
        viewModel.fetchProductosData().observe(this, Observer {
            adapter.setListData(it)
            adapter.notifyDataSetChanged()
        })
    }


    //private fun cat_Empresas() {
    //    title = "Restaurantes"
    //}
}