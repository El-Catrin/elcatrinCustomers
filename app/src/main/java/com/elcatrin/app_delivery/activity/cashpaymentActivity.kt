package com.elcatrin.app_delivery.activity

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.elcatrin.app_delivery.R
import com.elcatrin.app_delivery.viewModel.CartViewModel
import kotlinx.android.synthetic.main.activity_cash_payment.*
import java.io.IOException


class cashpaymentActivity: AppCompatActivity(), View.OnClickListener {
    private val order = CartViewModel.getOrder()
    private val save = CartViewModel.saveOrder(order)




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cash_payment)
        chkaceptarCambio.setOnClickListener(this)

    }


     override fun onClick(p0: View?){
        p0 as CheckBox
        var isCheckBox: Boolean = p0.isChecked
        when(p0.id){
            R.id.chkaceptarCambio -> if (isCheckBox){
                editTextCambio.visibility = View.VISIBLE
                Log.i("Estado","Se habilito el check")

                    btnContinuar.setOnClickListener {
                        retornarCambio()
                    }

            }
            else{
                editTextCambio.visibility = View.INVISIBLE
                Log.i("Estado","No se habilito el check")
                btnContinuar.setOnClickListener {
                    confirmarPedido()

                }
            }
        }
    }

    fun confirmarPedido(){
        btnContinuar.setOnClickListener {
            Log.i("Orden", order.toString())
            save


        }
    }
    fun showMessage(Titulo: String, Mensaje:String){

        val builder = AlertDialog.Builder(this)
        builder.setTitle(Titulo)
        builder.setMessage(Mensaje)
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }


    fun retornarCambio() {

        var total = order.subtotal + order.deliveryCost
        Log.i("Subtotal",order.subtotal.toString())
        Log.i("Costo de envio",order.deliveryCost.toString())
        Log.i("total",total.toString())
        var cambio = 0.0
try {
    if (editTextCambio.text.isNotEmpty()) {
        cambio = cambio + editTextCambio.text.toString().toDouble()
        Log.i("Vuelto", cambio.toString())
        if (cambio > total) {

            // Se envia la orden al comercio
            var resultado = cambio - total
            confirmarPedido()
            Log.i("Estado", "Se envio la orden y el cambio es el siguiente: " + resultado)
        } else {
            showMessage("Error", "Monto Insuficiente")
        }
    } else {
        showMessage("Error", "Ingrese un valor valido")
        Log.e("Estado", "No se envio la orden")

    }
}
catch(e: IOException){

    e.stackTrace
}
      }

        fun onHomePageClick(mi: MenuItem?) {
            val HomeActivity: Intent = Intent(this, HomeActivity::class.java).apply { }
            startActivity(HomeActivity)
        }

        fun onShoppingCartClick(mi: MenuItem?) {
            val cartActivity: Intent = Intent(this, CartActivity::class.java).apply { }
            startActivity(cartActivity)
        }

        fun onCurrentLocation(mi: MenuItem?) {
            val currentLocationOnMap: Intent =
                Intent(this, CurrentLocationOnMap::class.java).apply { }
            startActivity(currentLocationOnMap)
        }

//    fun onOrderListClick(mi: MenuItem?) {
//        val orderList: Intent = Intent(this, BillingActivity::class.java).apply { }
//        startActivity(orderList)
//    }
    }



