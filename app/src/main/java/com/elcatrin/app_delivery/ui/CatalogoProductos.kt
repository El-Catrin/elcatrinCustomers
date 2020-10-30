package com.elcatrin.app_delivery.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.elcatrin.app_delivery.ProductoAdapter
import com.elcatrin.app_delivery.Productos
import com.elcatrin.app_delivery.R
import kotlinx.android.synthetic.main.activity_catalogo_empresas.*
import kotlinx.android.synthetic.main.activity_catalogo_empresas.recyclerView
import kotlinx.android.synthetic.main.activity_catalogo_productos.*

class CatalogoProductos : AppCompatActivity() {

    private lateinit var adapter: ProductoAdapter

    // funcion para desplegar activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalogo_productos)

        adapter= ProductoAdapter(this)

        // instanciar recycley
        recyclerProductos.layoutManager= LinearLayoutManager(this)
        recyclerProductos.adapter = adapter

        val dummyList = mutableListOf<Productos>()
        dummyList.add(Productos("https://cocina-casera.com/wp-content/uploads/2016/11/hamburguesa-queso-receta.jpg",
            "Hamburgesa", "Rica","150"))
        dummyList.add(Productos("https://cocina-casera.com/wp-content/uploads/2016/11/hamburguesa-queso-receta.jpg",
            "Hamburgesa", "Rica","150"))
        dummyList.add(Productos("https://cocina-casera.com/wp-content/uploads/2016/11/hamburguesa-queso-receta.jpg",
            "Hamburgesa", "Rica","150"))
        dummyList.add(Productos("https://cocina-casera.com/wp-content/uploads/2016/11/hamburguesa-queso-receta.jpg",
            "Hamburgesa", "Rica","150"))

        adapter.setLisData(dummyList)
        adapter.notifyDataSetChanged()

    }


}