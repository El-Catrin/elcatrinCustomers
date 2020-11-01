package com.elcatrin.app_delivery.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.elcatrin.app_delivery.R
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.lista_productos.*

class VistaProductos: AppCompatActivity() {
    val dba= FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vista_productos)

        //mostrarProductos()
    }

    private fun mostrarProductos(){
        val actionBar: ActionBar? = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        var intent= intent
        val spCodigo= intent.getStringExtra("nombreProducto")
        dba.collection("Catolog_Products")
            .whereEqualTo("Cod_Company", spCodigo)
            .get()
            .addOnSuccessListener { result->
                for (document in result){
                    Glide.with(this).load(document.getString("Products_Image")).into(imaProductos)
                }
            }
    }


}