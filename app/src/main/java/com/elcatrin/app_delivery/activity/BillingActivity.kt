package com.elcatrin.app_delivery.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.elcatrin.app_delivery.R
import com.elcatrin.app_delivery.viewModel.CartViewModel
import kotlinx.android.synthetic.main.activity_billing.*

class BillingActivity : AppCompatActivity() {
    private val order = CartViewModel.getOrder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_billing)

        billing_user_id_txt.text = "hndoss"
        billing_price_txt.text = order.deliveryCost.toString()
        billing_delivery_price_txt.text = "100"
        billing_direction_txt.text = order.direction
        billing_time_txt.text = order.deliveryTime
    }
}