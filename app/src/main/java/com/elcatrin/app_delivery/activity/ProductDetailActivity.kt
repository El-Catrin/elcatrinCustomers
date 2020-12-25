package com.elcatrin.app_delivery.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.elcatrin.app_delivery.R
import com.elcatrin.app_delivery.model.Product
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_product_detail.*

class ProductDetailActivity : AppCompatActivity() {
    private val products = ArrayList<Product>()
    val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        getProduct()
//        setListeners()
    }

    private fun getProduct() {
        var intent = intent
        val acodigo = intent.getStringExtra("nombreProducto")

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

//    fun setListeners() {
//        btnComprar.setOnClickListener {
//            createProduct()
//            products.add()
////            val cartActivity: Intent = Intent(this, CartActivity::class.java).apply { }
////            startActivity(cartActivity)
//        }
//    }

//    private fun createProduct(){
//
//
//        return Product()
//    }
}