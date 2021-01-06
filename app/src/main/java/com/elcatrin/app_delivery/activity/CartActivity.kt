package com.elcatrin.app_delivery.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.elcatrin.app_delivery.R
import com.elcatrin.app_delivery.adapter.ProductAdapter
import com.elcatrin.app_delivery.viewModel.CartViewModel
import kotlinx.android.synthetic.main.activity_cart.*
import java.io.Serializable

class CartActivity : AppCompatActivity(), Serializable {
    private lateinit var productAdapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        setupRecycler()
    }

    private fun setupRecycler() {
        var shoppingList = CartViewModel.getShoppingList()

        productAdapter = ProductAdapter(this)
        productAdapter.setListData(shoppingList)

        recyclerCart.layoutManager = LinearLayoutManager(this)
        recyclerCart.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        recyclerCart.adapter = productAdapter
    }

}