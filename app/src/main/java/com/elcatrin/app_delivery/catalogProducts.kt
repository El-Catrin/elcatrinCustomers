package com.elcatrin.app_delivery

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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



        }

        }



    }
}