package com.elcatrin.app_delivery.ui

import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.elcatrin.app_delivery.R
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_vista_productos.*


class VistaProductos : AppCompatActivity() {

    // Access a Cloud Firestore instance from your Activity
    val db = FirebaseFirestore.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vista_productos)


       Producto()

    }

    private fun Producto() {

        //title = "Catalogo"

        //Código que recibe un dato de MainAdapter
        //val actionBar : ActionBar? = supportActionBar
        //actionBar!!.setDisplayHomeAsUpEnabled(true)
        //also set in manifest file, that which activity to move our another activity
        //now get data from putExtra intent
        var intent = intent
        val acodigo = intent.getStringExtra("nombreProducto")

        //set codigo in another activity
        //actionBar.setTitle(acodigo)

       //Query Firestore para vista productos
        db.collection("Catalog_Products")
            .whereEqualTo("Product_Name",acodigo)
            .get().addOnSuccessListener { result ->
            for (document in result) {
                nombreProducto.text = document.getString("Product_Name")
                precioProducto.text = document.getString("Product_Price")
                descripcionProducto.text = document.getString("Product_Desc")
                Glide.with(this).load(document.getString("Product_Image")).into(imageProducto)

            }
            }

    }
}