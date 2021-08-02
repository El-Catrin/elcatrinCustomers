package com.elcatrin.customers.activity

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.elcatrin.customers.R
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.android.synthetic.main.activity_auth.*
import java.io.IOException

enum class ProviderType
{
    BASIC,
    GOOGLE,
    FACEBOOK
}
class AuthActivity : AppCompatActivity() {
   private val GOOGLE_SING_IN = 100

    //val auth = AuthService()
    override fun onCreate(savedInstanceState: Bundle?) {
        Thread.sleep(2000)
        setTheme(R.style.AppTheme)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        //Funcion para iniciar sesion
        singIn()
        session()

        val analytics = FirebaseAnalytics.getInstance(this)
        val bundle = Bundle()
        bundle.putString("Message","Interagcion de fiber anakytics")
        analytics.logEvent("InitScreen", bundle)


    }



    override fun onStart() {
        super.onStart()
    }
    private fun session()
    {
        val prefs = getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE )
        val email :String? = prefs.getString("email", null)
        val provider :String? = prefs.getString("provider", null)
     try {
         if (email != null && provider != null) {
             lyAuth.visibility = View.INVISIBLE
           showHome(email, ProviderType.valueOf(provider))
         }
     } catch (e: IOException)
     {
         e.printStackTrace()
     }

    }


    // Funcion  de  autenticacion

    private fun singIn() {
        // Boton de Autententicacion por correo y contraseña
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

        // Boton de autenticacion por google

        googleButton.setOnClickListener {

            // Configuracion de la autenticacion por medio de google
            val googleConf = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build()

            // Cliente de autenticacion de google

            val  googleClient = GoogleSignIn.getClient(this, googleConf)
            googleClient.signOut()
            startActivityForResult(googleClient.signInIntent, GOOGLE_SING_IN)

        }

    }



    // Funcion para mostrar una alerta por falla de inicio de sesion
    fun showAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Favor valida tu Correo Electrónico o Contraseña")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()

    }
     // Funcion para navegar al activity principal
    fun showHome(email: String, provider: ProviderType) {

        val mapActivity: Intent = Intent(this, HomeActivity::class.java).apply {
            putExtra("email", email)
            putExtra("provider", provider)
        }
        startActivity(mapActivity)



    }

    // Funcion que retorna el usuario actual logeado
    fun showcurrentUser(): String? {

       val user =  FirebaseAuth.getInstance().currentUser
        val email = user.email
        Log.i("Cuenta de usuario", email)
        return email
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        try {
            if (requestCode == GOOGLE_SING_IN) {
                val task = GoogleSignIn.getSignedInAccountFromIntent(data)
                val account = task.getResult(ApiException::class.java)
                if (account != null) {
                    val credential = GoogleAuthProvider.getCredential(account.idToken, null)
                    FirebaseAuth.getInstance().signInWithCredential(credential)
                        .addOnCompleteListener {
                            if (it.isSuccessful) {

                                showHome(account.email?: "", ProviderType.GOOGLE)

                            } else {
                                    showAlert()

                                    }
                        }
                }
            }


        }catch (e: ApiException)

        {
            showAlert()
            e.printStackTrace()
        }
    }



}

