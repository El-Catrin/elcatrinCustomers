package com.elcatrin.app_delivery

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.elcatrin.app_delivery.ui.CatalogoEmpresas
import com.elcatrin.app_delivery.ui.CatalogoProductos
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_catalog_products.nameButton
import kotlinx.android.synthetic.main.activity_home.*


class homeActivity : AppCompatActivity() {

    // Access a Cloud Firestore instance from your Activity
    val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        showActivity()
   }

    private fun showActivity() {

        nameButton.setOnClickListener{

            val catalogProducts: Intent = Intent(this, catalogProducts::class.java).apply {
            }
            startActivity(catalogProducts)
        }

        img_btn_empresas.setOnClickListener {
           //val catalogo_empresas: Intent = Intent (this, CatalogoEmpresas::class.java).apply {
            val catalogo_productos: Intent = Intent (this, CatalogoProductos::class.java).apply{
            }
            startActivity(catalogo_productos)
        }
    }




    }
