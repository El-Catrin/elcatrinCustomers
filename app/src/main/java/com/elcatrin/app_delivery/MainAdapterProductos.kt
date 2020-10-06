package com.elcatrin.app_delivery

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.lista_productos.view.*

class MainAdapterProductos(private val context: Context): RecyclerView.Adapter<MainAdapterProductos.MainViewHolder>() {

    private var dataList = mutableListOf<Productos>()

    fun setListData(data:MutableList<Productos>){
        dataList = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.lista_productos,parent,false)
        return MainViewHolder(view)
    }

    override fun getItemCount(): Int {
        if (dataList.size > 0){
            return dataList.size
        }else{
            return 0
        }
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val productos:Productos = dataList[position]
        holder.bindView(productos)
    }

    inner class MainViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        fun bindView(productos:Productos){
            itemView.text_descProductos.text = productos.Product_Desc
            Glide.with(context).load(productos.Product_Image).into(itemView.img_productos)
            itemView.text_nombreProductos.text = productos.Product_Name
            itemView.text_precioProductos.text = productos.Product_Price
        }
    }
}