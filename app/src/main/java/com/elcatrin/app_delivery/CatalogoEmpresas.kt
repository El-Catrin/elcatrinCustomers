package com.elcatrin.app_delivery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_catalogo_empresas.*

class CatalogoEmpresas : AppCompatActivity() {

    // Access a Cloud Firestore instance from your Activity
    val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalogo_empresas)

        //Función Catálogo Empresas
        cat_Empresas()
    }

    private fun cat_Empresas() {
        title = "Restaurantes"


    }
}