package com.elcatrin.app_delivery

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.lista_empresa.view.*

class MainAdapter(private val context: Context): RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    private var dataList = mutableListOf<Empresa>()

    fun setListData(data:MutableList<Empresa>){
        dataList = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.lista_empresa,parent,false)
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
        val empresa:Empresa = dataList[position]
        holder.bindView(empresa)
    }

    inner class MainViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        fun bindView(empresa:Empresa){
            Glide.with(context).load(empresa.Logo_Company).into(itemView.img_logo)
            itemView.text_nombre.text = empresa.Name_Company
            itemView.text_desc.text = empresa.Desc_Company
            itemView.text_cost_min.text = empresa.Min_Cost
        }
    }
}