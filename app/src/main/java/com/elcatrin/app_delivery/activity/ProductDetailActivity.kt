package com.elcatrin.app_delivery.activity

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.elcatrin.app_delivery.R
import com.elcatrin.app_delivery.model.Product
import com.elcatrin.app_delivery.viewModel.CartViewModel
import com.elcatrin.app_delivery.viewModel.ProductViewModel
import kotlinx.android.synthetic.main.activity_product_detail.*

class ProductDetailActivity : AppCompatActivity() {
    private val productViewModel by lazy { ViewModelProvider(this).get(ProductViewModel::class.java) }
    private var product = Product()
    private lateinit var  cant : EditText
    private  lateinit var sumar: Button
    private lateinit var restar : Button
    private var cantCheck=0
    var productList: MutableList<Product> = mutableListOf<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)
        val productId = intent.getStringExtra("productId")
        getProductById(productId)
        setListeners()
        counter()
    }

    private fun getProductById(productId: String?) {
        productViewModel.getProductById(productId).observe(this, Observer {
            var p = it[0]
            product = p
            nombreProducto.text = product.name
            precioProducto.text = product.price.toString()
            descripcionProducto.text = product.description
            Glide.with(this).load(product.image).into(imageProducto)
        })
    }


    private fun counter () {
       // cant = findViewById(R.id.cantProducto)
        sumar = findViewById(R.id.addProduct)
        restar = findViewById(R.id.substractProduct)

        sumar.setOnClickListener {
            cantCheck += 1
        }

        restar.setOnClickListener {
            if (cantCheck > 0) {
                cantCheck--
            } else {
                Toast.makeText(this, "Ingresa un cantidad superior", Toast.LENGTH_SHORT).show()
            }

        }
    }
    private fun setListeners() {


        btnComprar.setOnClickListener {
            if (cantCheck > 0){
            CartViewModel.addProduct(product)
            CartViewModel.getCant(cantProducto?.text.toString())
            val cartActivity: Intent = Intent(this, CartActivity::class.java).apply { }
                cartActivity.putExtra("CantProduct", cantCheck)
            startActivity(cartActivity)}
            else {
                Toast.makeText(this,"Favor ingrese la cantidad del producto", Toast.LENGTH_LONG).show()
            }
        }


        }



    fun onHomePageClick(mi: MenuItem?) {
        val HomeActivity: Intent = Intent(this, HomeActivity::class.java).apply { }
        startActivity(HomeActivity)
    }

    fun onOrderListClick(mi: MenuItem?) {
        val ordersActivity: Intent = Intent(this, OrdersActivity::class.java).apply { }
        startActivity(ordersActivity)
    }
}