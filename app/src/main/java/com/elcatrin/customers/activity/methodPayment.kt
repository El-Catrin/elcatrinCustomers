package com.elcatrin.customers.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.elcatrin.customers.R
import kotlinx.android.synthetic.main.activity_method_payment.*

class methodPayment : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_method_payment)

        creditCard()
        cashPayment()
    }

    fun creditCard() {
        btnTarjeta.setOnClickListener {
            /*  val credicardactivity: Intent = Intent(this, creditcardActivity::class.java).apply {
              }
              startActivity(credicardactivity)*/
            Toast.makeText(this, "El servicio no esta disponible", Toast.LENGTH_SHORT).show()
            Log.i("Activity", "Se dio clic en el boton de tarjeta de credito")
        }
    }

    fun cashPayment() {
        btnEfectivo.setOnClickListener {
            val cashpaymentactivity: Intent = Intent(this, cashpaymentActivity::class.java).apply {
            }
            startActivity(cashpaymentactivity)
            Log.i("Activity", "Se dio clic en el boton de pago en efectivo")
        }

    }

    fun onHomePageClick(mi: MenuItem?) {
        val HomeActivity: Intent = Intent(this, HomeActivity::class.java).apply { }
        startActivity(HomeActivity)
    }


    fun onOrderListClick(mi: MenuItem?) {
        val ordersActivity: Intent = Intent(this, OrdersActivity::class.java).apply { }
        startActivity(ordersActivity)
    }
}