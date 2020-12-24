package com.elcatrin.app_delivery.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.elcatrin.app_delivery.R
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        showActivity()
    }

    private fun showActivity() {
        img_btn_empresas.setOnClickListener {
            val catalogoEmpresas: Intent = Intent(this, CatalogoEmpresas::class.java).apply { }
            startActivity(catalogoEmpresas)
        }
    }
}
