package com.elcatrin.app_delivery

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.elcatrin.app_delivery.domain.data.network.RepoProductos
import com.elcatrin.app_delivery.ui.CatalogoProductos
import kotlinx.android.synthetic.main.lista_empresa.view.*

class MainAdapter(private val context: Context): RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
    //, private val itemClickListener: OnEmpresaClickListener

    private var dataList = mutableListOf<Empresa>()

    //interface OnEmpresaClickListener {
        //fun onItemClick()
    //}

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

        //Código para enviar un dato a otra actividad
        holder.itemView.setOnClickListener {
            //get position of selected item
            val model = dataList.get(position)
            //get Cod_Company of selected item whit intent
            var gcodigo : String = model.Cod_Company

            //create intent in kotlin
            val intent = Intent(context, CatalogoProductos::class.java)

            //now put all these items whit putExtra intent
            intent.putExtra("codigoEmpresa", gcodigo)

            context.startActivity(intent)

        }
    }

    inner class MainViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        fun bindView(empresa:Empresa){

            //itemView.setOnClickListener { itemClickListener.onItemClick() }

            Glide.with(context).load(empresa.Logo_Company).into(itemView.img_logo)
            itemView.text_nombre.text = empresa.Name_Company
            itemView.text_desc.text = empresa.Desc_Company
            Glide.with(context).load(empresa.Company_Banner).into(itemView.img_empresa)
            itemView.text_horario.text = empresa.Working_Hours
            itemView.text_cost_min.text = empresa.Min_Cost
        }
    }
}


