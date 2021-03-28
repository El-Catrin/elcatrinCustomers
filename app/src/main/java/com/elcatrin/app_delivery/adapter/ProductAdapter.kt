package com.elcatrin.app_delivery.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.elcatrin.app_delivery.R
import com.elcatrin.app_delivery.activity.ProductDetailActivity
import com.elcatrin.app_delivery.model.Product
import kotlinx.android.synthetic.main.recycler_product.view.*

class ProductAdapter(private val context: Context) :
    RecyclerView.Adapter<ProductAdapter.ProductsViewHolder>() {

    private var dataList = mutableListOf<Product>()

    fun setListData(data: MutableList<Product>) {
        dataList = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val productView =
            LayoutInflater.from(context).inflate(R.layout.recycler_product, parent, false)
        return ProductsViewHolder(productView)
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        val products = dataList[position]
        holder.productBindView(products)

        holder.itemView.setOnClickListener {
            val product = dataList[position]
            var productId: String = product.id
            val intentProducts = Intent(context, ProductDetailActivity::class.java)

            intentProducts.putExtra("productId", productId)
            context.startActivity(intentProducts)
        }
    }

    override fun getItemCount(): Int {
        if (dataList.size > 0)
            return dataList.size

        return 0
    }

    inner class ProductsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun productBindView(product: Product) {
            Glide.with(context).load(product.image).into(itemView.imaProductos)
            itemView.txtNombreProductos.text = product.name
            itemView.txt_Descripcion.text = product.description
            itemView.txt_Precio.text = product.price
        }
    }
}