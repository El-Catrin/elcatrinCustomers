package com.elcatrin.app_delivery

import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_catalog_products.*

class catalogProducts : AppCompatActivity() {

    // Access a Cloud Firestore instance from your Activity
    val db = FirebaseFirestore.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalog_products)

        //Catalog_Product
        catalogProduct()

    }

    private fun catalogProduct() {

        title = "Catalogo"

        //Código que recibe un dato de MainAdapter
        val actionBar : ActionBar? = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        //also set in manifest file, that which activity to move our another activity
        //now get data from putExtra intent
        var intent = intent
        val acodigo = intent.getStringExtra("codigoEmpresa")

        //set codigo in another activity
        actionBar.setTitle(acodigo)
        nameTextView.text = acodigo

        nameButton.setOnClickListener{

        db.collection("Catalog_Products").whereEqualTo("Cod_Company",acodigo).get().addOnSuccessListener { result ->
            //nameTextView.setText(it.get("Product_Name") as String?)
            for (document in result) {
                priceTextView.text = document.getString("Cod_Company")
                }
            }
        }
    }
}