package com.elcatrin.app_delivery.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.elcatrin.app_delivery.R
import kotlinx.android.synthetic.main.activity_billing.*
import kotlinx.android.synthetic.main.activity_method_payment.*

class methodPayment : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_method_payment)

        creditCard()
        cashPayment()
    }

    fun creditCard(){
        btnTarjeta.setOnClickListener {
            val credicardactivity: Intent = Intent(this, creditcardActivity::class.java).apply {
            }
            startActivity(credicardactivity)

            Log.i("Activity", "Se dio clic en el boton de tarjeta de credito")
        }
    }

    fun cashPayment(){
        btnEfectivo.setOnClickListener {
            val cashpaymentactivity: Intent = Intent(this, cashpaymentActivity::class.java).apply {
            }
            startActivity(cashpaymentactivity)
            Log.i("Activity", "Se dio clic en el boton de pago en efectivo")
        }

    }
}