package com.elcatrin.customers.activity

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.elcatrin.customers.R
import kotlinx.android.synthetic.main.activity_home.*



class HomeActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setListeners()
        Log.d("APP STATUS", "Started")

        //Capturar los datos de la activity autenticacion
        val bundle:Bundle? = intent.extras
        val email:String? = bundle?.getString("email")
        val provider:String? = bundle?.getString("provider")
        //Guardar datos de sesion permanente
        val prefs = getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE ).edit()
        prefs.putString("email", email)
        prefs.putString("provider", provider)
        prefs.apply()
    }

    private fun setListeners() {
        img_btn_empresas.setOnClickListener {
            val storesActivity: Intent = Intent(this, StoresActivity::class.java).apply { }
            startActivity(storesActivity)
        }

        img_btn_entretenimiento.setOnClickListener {
            Toast.makeText(this, "El servicio no se encuentra disponible",  Toast.LENGTH_SHORT).show()
        }
        img_btn_belleza.setOnClickListener {
            Toast.makeText(this, "El servicio no se encuentra disponible",  Toast.LENGTH_SHORT).show()
        }
        img_btn_farmacia.setOnClickListener {
            Toast.makeText(this, "El servicio no se encuentra disponible",  Toast.LENGTH_SHORT).show()
        }
        img_btn_panaderias.setOnClickListener {
            Toast.makeText(this, "El servicio no se encuentra disponible",  Toast.LENGTH_SHORT).show()
        }
        img_btn_restaurantes.setOnClickListener {
            Toast.makeText(this, "El servicio no se encuentra disponible",  Toast.LENGTH_SHORT).show()
        }
        img_btn_supermercados.setOnClickListener {
            Toast.makeText(this, "El servicio no se encuentra disponible",  Toast.LENGTH_SHORT).show()
        }
        img_btn_tecnologia.setOnClickListener {
            Toast.makeText(this, "El servicio no se encuentra disponible",  Toast.LENGTH_SHORT).show()
        }
        img_btn_ferreteria.setOnClickListener {
            Toast.makeText(this, "El servicio no se encuentra disponible",  Toast.LENGTH_SHORT).show()
        }

        buttonBuscar.setOnClickListener {
            Toast.makeText(this, "El servicio no se encuentra disponible",  Toast.LENGTH_SHORT).show()
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
