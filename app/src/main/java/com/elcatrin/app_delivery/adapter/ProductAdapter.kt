package com.elcatrin.app_delivery.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.elcatrin.app_delivery.R
import com.elcatrin.app_delivery.activity.ProductDetailActivity
import com.elcatrin.app_delivery.model.Product
import kotlinx.android.synthetic.main.lista_productos.view.*

class ProductAdapter(private val context: Context) :
    RecyclerView.Adapter<ProductAdapter.ProductosViewHolder>() {

    private var dataList = mutableListOf<Product>()

    fun setLisData(data: MutableList<Product>) {
        dataList = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductosViewHolder {
        val productoView =
            LayoutInflater.from(context).inflate(R.layout.lista_productos, parent, false)
        return ProductosViewHolder(productoView)
    }

    override fun onBindViewHolder(holder: ProductosViewHolder, position: Int) {
        val products = dataList[position]
        holder.productosbindView(products)

        holder.itemView.setOnClickListener {
            val modelProductos = dataList.get(position)
            var pCodigo: String = modelProductos.name
            val intentProductos = Intent(context, ProductDetailActivity::class.java)

            intentProductos.putExtra("nombreProducto", pCodigo)
            context.startActivity(intentProductos)
        }
    }

    override fun getItemCount(): Int {
        return if (dataList.size > 0) {
            dataList.size
        } else {
            0
        }
    }

    inner class ProductosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun productosbindView(product: Product) {
            Glide.with(context).load(product.image).into(itemView.imaProductos)
            itemView.txtNombreProductos.text = product.name
            itemView.txt_Descripcion.text = product.description
            itemView.txt_Precio.text = product.price
        }
    }
}