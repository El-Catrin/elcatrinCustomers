package com.elcatrin.app_delivery.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.elcatrin.app_delivery.R
import com.elcatrin.app_delivery.adapter.OrderAdapter
import com.elcatrin.app_delivery.viewModel.OrderViewModel
import com.google.firebase.auth.FirebaseAuth

import kotlinx.android.synthetic.main.activity_orders.*

class OrdersActivity : AppCompatActivity() {
    private lateinit var adapter: OrderAdapter
    private val uid = FirebaseAuth.getInstance().currentUser?.uid

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orders)

        adapter = OrderAdapter(this)
        recyclerOrder.layoutManager = LinearLayoutManager(this)
        recyclerOrder.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        recyclerOrder.adapter = adapter

        OrderViewModel.getOrderByUserId(uid.toString())
            .observe(this, Observer {
                adapter.setOrders(it)
                adapter.notifyDataSetChanged()
            })
    }
}