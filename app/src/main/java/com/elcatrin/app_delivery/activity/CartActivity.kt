package com.elcatrin.app_delivery.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.elcatrin.app_delivery.R
import com.elcatrin.app_delivery.adapter.CartProductAdapter
import com.elcatrin.app_delivery.viewModel.CartViewModel
import kotlinx.android.synthetic.main.activity_cart.*
import java.io.Serializable

class CartActivity : AppCompatActivity(), Serializable {
    private lateinit var productAdapter: CartProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        setupRecycler()
        Log.d("Total", CartViewModel.getTotal().toString())
    }

    private fun setupRecycler() {
        var shoppingList = CartViewModel.getShoppingList()

        productAdapter = CartProductAdapter(this)
        productAdapter.setListData(shoppingList)

        recyclerCart.layoutManager = LinearLayoutManager(this)
        recyclerCart.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        recyclerCart.adapter = productAdapter
    }

}