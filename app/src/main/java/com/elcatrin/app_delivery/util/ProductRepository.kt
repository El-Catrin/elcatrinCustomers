package com.elcatrin.app_delivery.util

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.elcatrin.app_delivery.database.Products
import com.elcatrin.app_delivery.model.Product

class ProductRepository : ViewModel() {
    private val repo = Products()

    fun fetchUserData(): LiveData<MutableList<Product>> {
        val mutableData = MutableLiveData<MutableList<Product>>()
        repo.getUserData().observeForever { userList ->
            mutableData.value = userList
        }
        return mutableData
    }
}