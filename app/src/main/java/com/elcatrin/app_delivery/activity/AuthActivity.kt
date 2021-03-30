package com.elcatrin.app_delivery.activity

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.elcatrin.app_delivery.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_auth.*
import java.io.IOException

enum class ProviderType
{
    BASIC,
    GOOGLE,
    FACEBOOK
}
class AuthActivity : AppCompatActivity() {


    //val auth = AuthService()
    override fun onCreate(savedInstanceState: Bundle?) {
        Thread.sleep(2000)
        setTheme(R.style.AppTheme)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        singIn()

    }

    private fun singIn() {

        singInbutton.setOnClickListener {
            try {
                if (emailEdittext.text.isNotEmpty() && editPassword.text.isNotEmpty()) {
                    FirebaseAuth.getInstance().signInWithEmailAndPassword(
                        emailEdittext.text.toString(),
                        editPassword.text.toString()
                    ).addOnCompleteListener {
                        if (it.isSuccessful) {

                            showHome(it.result?.user?.email ?: "", ProviderType.BASIC)
                            showcurrentUser()
                        }
                    }
                } else {

                    showAlert()

                }
            } catch (e: IOException) {
                e.printStackTrace()
            }


        }


    }

    fun showAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error autenticando al usuario")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()

    }

    fun showHome(email: String, provider: ProviderType) {

        val homeActivity: Intent = Intent(this, HomeActivity::class.java).apply {
            putExtra("email", email)
            putExtra("provider", provider)
        }
        startActivity(homeActivity)



    }



    fun showcurrentUser(): String? {

       val user =  FirebaseAuth.getInstance().currentUser
        val email = user.email
        Log.i("Cuenta de usuario", email)
        return email
    }


}

