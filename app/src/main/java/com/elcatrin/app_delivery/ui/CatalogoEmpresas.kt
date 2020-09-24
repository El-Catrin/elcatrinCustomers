package com.elcatrin.app_delivery.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.elcatrin.app_delivery.MainAdapter
import com.elcatrin.app_delivery.viewmodel.MainViewModel
import com.elcatrin.app_delivery.R
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_catalogo_empresas.*

class CatalogoEmpresas : AppCompatActivity() {

    // Access a Cloud Firestore instance from your Activity
    val db = FirebaseFirestore.getInstance()

    //Al declararlo como lateinit var debo inicializarlo antes de usarlo
    private lateinit var adapter: MainAdapter
    //Al declararlo con lazy se inicializa cuando lo necesito, o sea automáticamente
    private val viewModel by lazy { ViewModelProvider.of(this).get(MainViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalogo_empresas)

        //Inicializo el adapter que declare arriba
        adapter = MainAdapter(this)
        //Inicialización del recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        //Función Catálogo Empresas
        cat_Empresas()
    }


    private fun cat_Empresas() {
        title = "Restaurantes"


    }
}