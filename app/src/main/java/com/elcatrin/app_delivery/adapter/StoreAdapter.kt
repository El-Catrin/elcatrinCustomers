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

class StoreAdapter(private val context: Context) :
    RecyclerView.Adapter<StoreAdapter.StoreViewHolder>() {
    private var stores = mutableListOf<Store>()

    fun setStores(data: MutableList<Store>) {
        stores = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.lista_empresa, parent, false)
        return StoreViewHolder(view)
    }

    override fun getItemCount(): Int {
        if (stores.size > 0)
            return stores.size
        return 0
    }

    override fun onBindViewHolder(holder: StoreViewHolder, position: Int) {
        val store: Store = stores[position]
        holder.bindView(store)

        holder.itemView.setOnClickListener {
            val productsActivity = Intent(context, ProductsActivity::class.java)
            productsActivity.putExtra("storeId", store.Cod_Company)
            context.startActivity(productsActivity)
        }
    }

    inner class StoreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(store: Store) {
            Glide.with(context).load(store.Logo_Company).into(itemView.img_logo)
            itemView.text_nombre.text = store.Name_Company
            itemView.text_desc.text = store.Desc_Company
            Glide.with(context).load(store.Company_Banner).into(itemView.img_empresa)
            itemView.text_horario.text = store.Working_Hours
            itemView.text_cost_min.text = store.Min_Cost
        }
    }
}


