package com.elcatrin.app_delivery.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.elcatrin.app_delivery.R
import com.elcatrin.app_delivery.activity.ProductsActivity
import com.elcatrin.app_delivery.model.Store
import kotlinx.android.synthetic.main.lista_empresa.view.*

class MainAdapter(private val context: Context) :
    RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
    private var dataList = mutableListOf<Store>()

    fun setListData(data: MutableList<Store>) {
        dataList = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.lista_empresa, parent, false)
        return MainViewHolder(view)
    }

    override fun getItemCount(): Int {
        if (dataList.size > 0) {
            return dataList.size
        } else {
            return 0
        }
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val empresa: Store = dataList[position]
        holder.bindView(empresa)
        holder.itemView.setOnClickListener {
            val model = dataList.get(position)
            var gcodigo: String = model.Cod_Company
            val intent = Intent(context, ProductsActivity::class.java)
            intent.putExtra("codigoEmpresa", gcodigo)

            context.startActivity(intent)
        }
    }

    inner class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(empresa: Store) {
            Glide.with(context).load(empresa.Logo_Company).into(itemView.img_logo)
            itemView.text_nombre.text = empresa.Name_Company
            itemView.text_desc.text = empresa.Desc_Company
            Glide.with(context).load(empresa.Company_Banner).into(itemView.img_empresa)
            itemView.text_horario.text = empresa.Working_Hours
            itemView.text_cost_min.text = empresa.Min_Cost
        }
    }
}


