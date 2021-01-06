package com.elcatrin.app_delivery.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.elcatrin.app_delivery.R

class CartAdapter(
    val context: Context
) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {
    private var totalSum = 0


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cart_item, parent, false)
        return CartViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 0
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.txtProductName.text = "0"
        holder.txtProductCost.text = "0"
    }

    class CartViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtProductName: TextView = view.findViewById(R.id.txtProductName)
        val txtProductCost: TextView = view.findViewById(R.id.txtProductCost)
    }

}