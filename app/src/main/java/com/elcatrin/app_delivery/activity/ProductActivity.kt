package com.elcatrin.app_delivery.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.elcatrin.app_delivery.R
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_vista_productos.*

class ProductActivity : AppCompatActivity() {
    val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vista_productos)
        getProduct()
        addToCart()
    }

    private fun getProduct() {
        var intent = intent
        val acodigo = intent.getStringExtra("nombreProducto")

        //Query Firestore para vista productos
        db.collection("Catalog_Products")
            .whereEqualTo("Product_Name", acodigo)
            .get().addOnSuccessListener { result ->
                for (document in result) {
                    nombreProducto.text = document.getString("Product_Name")
                    precioProducto.text = document.getString("Product_Price")
                    descripcionProducto.text = document.getString("Product_Desc")
                    Glide.with(this).load(document.getString("Product_Image")).into(imageProducto)
                }
            }
    }

    fun addToCart(){
        btnComprar.setOnClickListener {
            val cartActivity: Intent = Intent(this, CartActivity::class.java).apply { }
            startActivity(cartActivity)
        }
    }
}