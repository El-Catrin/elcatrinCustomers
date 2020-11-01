package com.elcatrin.app_delivery

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.lista_productos.view.*

class ProductoAdapter(private val context: Context):
    RecyclerView.Adapter<ProductoAdapter.ProductosViewHolder>() {



private var dataList= mutableListOf<Productos>()
    fun setLisData(data:MutableList<Productos>){
        dataList= data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductosViewHolder {
        val productoView = LayoutInflater.from(context).inflate(R.layout.lista_productos, parent, false)
        return ProductosViewHolder(productoView)
    }

    override fun onBindViewHolder(holder: ProductosViewHolder, position: Int) {
        val productos= dataList[position]
        holder.productosbindView(productos)
    }

    override fun getItemCount(): Int {
        return if(dataList.size > 0){
            dataList.size
        } else {
            0
        }
    }

    inner class ProductosViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){

        fun productosbindView(productos: Productos){



            Glide.with(context).load(productos.Product_Image).into(itemView.imaProductos)
            itemView.txtNombreProductos.text= productos.Product_Name
            itemView.txt_Descripcion.text=productos.Product_Desc
            itemView.txt_Precio.text=productos.Product_Price
            //itemView.textCodigo.text=productos.Cod_Company
        }
    }
}