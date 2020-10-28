package com.elcatrin.app_delivery

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.lista_productos.view.*

class ProductoAdapter(private val mContext: Context, private val Lista: List<Productos> ) : ArrayAdapter<Productos>( mContext, 0, Lista) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
       val Layout = LayoutInflater.from(mContext).inflate(R.layout.lista_productos, parent, false)

        val productos = Lista [position]

        Layout.nombre.text= productos.Nombre
        Layout.precio.text= "$${productos.Precio}"
        Layout.img.setImageResource(productos.Imagen)

        return Layout

    }
}