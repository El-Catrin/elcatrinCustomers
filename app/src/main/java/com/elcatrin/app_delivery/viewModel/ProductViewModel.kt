package com.elcatrin.app_delivery.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.elcatrin.app_delivery.domain.data.network.ProductService
import com.elcatrin.app_delivery.model.Product

class ProductViewModel : ViewModel() {
    private val productService = ProductService()

    fun getProductsByStoreId(storeId: String): LiveData<MutableList<Product>> {
        val mutableData = MutableLiveData<MutableList<Product>>()
        productService.getProductByStoreId(storeId).observeForever { userList ->
            mutableData.value = userList
        }
        return mutableData
    }
}