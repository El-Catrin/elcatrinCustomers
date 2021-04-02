package com.elcatrin.app_delivery.activity

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity
import com.elcatrin.app_delivery.R
import com.elcatrin.app_delivery.viewModel.CartViewModel
import kotlinx.android.synthetic.main.activity_cash_payment.*

class cashpaymentActivity: AppCompatActivity(), View.OnClickListener {
    private val order = CartViewModel.getOrder()
    private val save = CartViewModel.saveOrder(order)



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cash_payment)
        chkaceptarCambio.setOnClickListener(this)
        confirmarPedido()
    }


     override fun onClick(p0: View?){
        p0 as CheckBox
        var isCheckBox: Boolean = p0.isChecked
        when(p0.id){
            R.id.chkaceptarCambio -> if (isCheckBox){
                editTextCambio.visibility = View.VISIBLE
                Log.i("Estado","Se habilito el check")
            }
            else{
                editTextCambio.visibility = View.INVISIBLE
            }
        }

    }
    fun confirmarPedido(){
        btnContinuar.setOnClickListener {
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


    fun retornarCambio(): Double {
        var total = order.subtotal + order.deliveryCost

        var cambio = editTextCambio
        if( 10.0 > total){
            var suma=total

        }
        else{
            showMessage("Error", "Monto Insuficiente")
        }
        return total
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
        val currentLocationOnMap: Intent = Intent(this, CurrentLocationOnMap::class.java).apply { }
        startActivity(currentLocationOnMap)
    }

//    fun onOrderListClick(mi: MenuItem?) {
//        val orderList: Intent = Intent(this, BillingActivity::class.java).apply { }
//        startActivity(orderList)
//    }

}