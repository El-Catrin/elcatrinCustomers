package com.elcatrin.app_delivery.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.elcatrin.app_delivery.ProductoAdapter
import com.elcatrin.app_delivery.Productos
import com.elcatrin.app_delivery.R
import kotlinx.android.synthetic.main.mostrar_productos.*

class MainProductos : AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mostrar_productos)

        val productos = Productos("Hamburgesa", 100, "Homburgesa Grande", R.drawable.hambur)
        val productos2 = Productos("Computadora", 10000, "18 Gb", R.drawable.compu)
        val productos3 = Productos("Tacos", 100, "Tacos de Pollo o Res", R.drawable.tacos)

        val listaPro = listOf(productos, productos2, productos3)

        val Adapter = ProductoAdapter (this, listaPro)

        Lista.adapter = Adapter


    }

}