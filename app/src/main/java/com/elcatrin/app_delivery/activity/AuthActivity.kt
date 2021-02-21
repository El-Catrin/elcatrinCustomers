package com.elcatrin.app_delivery.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.elcatrin.app_delivery.R
import kotlinx.android.synthetic.main.activity_auth.*

class AuthActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

      singin ()
    }

    private  fun singin() {

        singInbutton.setOnClickListener()
        {
            val homeActivity: Intent = Intent(this, HomeActivity::class.java).apply { }
            startActivity(homeActivity)

        }

    }

    }


