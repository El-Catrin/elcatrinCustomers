package com.elcatrin.app_delivery.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.elcatrin.app_delivery.R
import com.elcatrin.app_delivery.model.Order
import kotlinx.android.synthetic.main.recycler_order.view.*

class OrderAdapter(private val context: Context) :
    RecyclerView.Adapter<OrderAdapter.OrderViewHolder>() {
    private var orders = mutableListOf<Order>()

    fun setOrders(data: MutableList<Order>) {
        orders = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recycler_order, parent, false)
        return OrderViewHolder(view)
    }

    override fun getItemCount(): Int {
        if (orders.size > 0)
            return orders.size
        return 0
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val order: Order = orders[position]
        holder.bindView(order)
    }

    inner class OrderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(order: Order) {
            val suma = order.subtotal + order.deliveryCost
            itemView.subtotal_txt.text = suma.toString()
        }
    }
}


