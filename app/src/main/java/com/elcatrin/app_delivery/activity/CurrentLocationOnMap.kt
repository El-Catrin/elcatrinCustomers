package com.elcatrin.app_delivery.activity

import android.content.Intent
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.core.app.ActivityCompat
import com.elcatrin.app_delivery.R
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_current_location_on_map.*
import java.util.*

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

val uid = FirebaseAuth.getInstance().currentUser?.uid

class CurrentLocationOnMap : AppCompatActivity(), OnMapReadyCallback {
    //Creamos una variable para que cada vez que movamos el marcador, sea una nueva posición
    var currentMarker: Marker? = null
private val user = AuthActivity().showcurrentUser()
    private lateinit var mMap: GoogleMap

    //Nos da la ubicación instantánea de la última ubicación conocida
    var fusedLocationProviderClient: FusedLocationProviderClient? = null
    //variable global para nuestra ubicación actual
    var currentLocation: Location? = null




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_current_location_on_map)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        /*val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)*/


        Log.d("Usuario Actual", user.toString())
            fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)
        fetchLocation()

        guardarUbicacion.setOnClickListener {

        }
    }


    //Función para decirle que nos debe dar permisos
    private fun fetchLocation() {
        if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION)
            != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), 1000)
            return
        }

        val task = fusedLocationProviderClient?.lastLocation
        task?.addOnSuccessListener { location ->
            if (location != null) {
                this.currentLocation = location
                val mapFragment = supportFragmentManager
                    .findFragmentById(R.id.map) as SupportMapFragment
                mapFragment.getMapAsync(this)
            }
        }
    }

    //Y en este verificamos si se nos dieron los permisos o no
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode) {
           1000 -> if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
               fetchLocation()
           }
       }
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        //Esto no lo necestio ya que es una ubicación codificada
        /*val sydney = LatLng(-34.0, 151.0)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))*/

        //Creo un objeto latlong con la ubicación actual
        val latlong = LatLng(currentLocation?.latitude!!, currentLocation?.longitude!!)
        drawMarker(latlong)

        FirebaseFirestore.getInstance().collection("User_GPS").document("01 - FG").update("Longitude",currentLocation?.longitude!!,
            "Latitude",currentLocation?.latitude!!).addOnSuccessListener {  }

        //Arrastrar el marcador
        mMap.setOnMarkerDragListener(object : GoogleMap.OnMarkerDragListener {
            override fun onMarkerDrag(p0: Marker?) {

            }

            override fun onMarkerDragEnd(p0: Marker?) {
                //Con la variable creada dibujamos el nuevo marcador en nuestro mapa
                //Compruebo si el marcador actual no es igual o nulo
                if(currentMarker != null)
                    currentMarker?.remove() //Así que lo remueve
                val newLatLng = LatLng(p0?.position!!.latitude, p0?.position.longitude) //Y consigue la nueva posición de LatLong
                drawMarker(newLatLng)
            }

            override fun onMarkerDragStart(p0: Marker?) {

            }
        })

    }

    //Función para dibujar marcador
    private fun drawMarker(latlong : LatLng) {
        val markerOption = MarkerOptions().position(latlong).title("Estoy aquí")
                //La opción del marcador la dejo en true (draggable)
            .snippet(getAddress(latlong.latitude, latlong.latitude)).draggable(true)

        mMap.animateCamera(CameraUpdateFactory.newLatLng(latlong))
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlong, 15f))
        currentMarker = mMap.addMarker(markerOption)
        currentMarker?.showInfoWindow()
    }

    private fun getAddress(lat: Double, lon: Double): String? {
        //Aquí utilizamos la api Geocoder
        val geoCoder = Geocoder(this, Locale.getDefault())
        //Nos devuelve una lista de direcciones, la latitud y longitud así que tomamos una
        val addresses = geoCoder.getFromLocation(lat, lon, 1)
        return addresses[0].getAddressLine(0).toString()
    }


}