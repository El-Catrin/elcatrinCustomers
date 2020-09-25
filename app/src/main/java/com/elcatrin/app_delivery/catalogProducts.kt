package com.elcatrin.app_delivery

import android.os.Bundle
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

        nameButton.setOnClickListener{

        db.collection("Products").document("Big_Stacker_Burger_King").get().addOnSuccessListener {
            nameTextView.setText(it.get("Product_Name") as String?)
            priceTextView.setText(it.get("Price") as String?)
            descTextView.setText(it.get("Product_Desc") as String?)
            catTextView.setText(it.get("Product_Categ") as String?)
            //Mostrar una imagen de forma estatica
            Glide.with(this).load("data:image/png;base64,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").into(imageView)
        }

        }



    }
}