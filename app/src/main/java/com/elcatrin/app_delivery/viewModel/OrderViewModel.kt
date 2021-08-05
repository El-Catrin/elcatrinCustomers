package com.elcatrin.app_delivery.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.elcatrin.app_delivery.domain.data.network.OrderService
import com.elcatrin.app_delivery.model.Order

class OrderViewModel : ViewModel() {

    companion object {
        private val orderService = OrderService()

        fun getOrderByUserId(userId: String): LiveData<MutableList<Order>> {
            val mutableData = MutableLiveData<MutableList<Order>>()
            orderService.getOrdersByUserId(userId).observeForever { orderList ->
                mutableData.value = orderList
            }
            return mutableData
        }
    }
}