package com.elcatrin.customers.domain.data.network



import com.google.firebase.auth.FirebaseAuth
import java.io.IOException


class AuthActivity() {

    lateinit var  auth:FirebaseAuth

      fun authActivity()
    {
         auth = FirebaseAuth.getInstance()
     }
    //Metodo para ingresar con el usuario
    fun singIn(email: String, password: String) {
        try {
            if (email.isNotEmpty() && password.isNotEmpty()) {
                auth.createUserWithEmailAndPassword(email.toString(), password.toString())
                    .addOnCompleteListener {
                      if (it.isSuccessful){



                      }else {

                                               }
                    }
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }

    }



    //Funcion para registro de usuarios

     fun singUp (email: String, password: String) {
         try {
             if (email.isNotEmpty() && password.isNotEmpty())
             {
                 auth.createUserWithEmailAndPassword(
                     email.toString(),
                     password.toString()
                 )
             }
         } catch (e: IOException)

         {
             e.printStackTrace()
         }

     }





    }
