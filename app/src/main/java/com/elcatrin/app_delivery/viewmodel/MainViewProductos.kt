package com.elcatrin.app_delivery.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.elcatrin.app_delivery.Productos
import com.elcatrin.app_delivery.domain.data.network.RepoProductos

class MainViewProductos: ViewModel(){

    val repo= RepoProductos()



    fun fetchUserData(): LiveData<MutableList<Productos>> {
    val mutableData = MutableLiveData<MutableList<Productos>>()
    repo.getUserData().observeForever{ userList->
        mutableData.value= userList



            }
        return mutableData
}

}