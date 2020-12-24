package com.elcatrin.app_delivery.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.elcatrin.app_delivery.R
import com.elcatrin.app_delivery.adapter.CartAdapter
import java.io.Serializable

class CartActivity : AppCompatActivity(), Serializable {
    private lateinit var recyclerAdapter: CartAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)
        recyclerView = findViewById(R.id.recyclerCart)
        layoutManager = LinearLayoutManager(this@CartActivity)

        val cartName = intent.getStringArrayListExtra("cartName")
        val cartCost = intent.getStringArrayListExtra("cartCost")

//        recyclerAdapter = CartAdapter(this@CartActivity, cartName!!, cartCost!!)
//        recyclerView.adapter = recyclerAdapter
//        recyclerView.layoutManager = layoutManager
    }
}