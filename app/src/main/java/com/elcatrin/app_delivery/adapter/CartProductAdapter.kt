package com.elcatrin.app_delivery.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.elcatrin.app_delivery.R
import com.elcatrin.app_delivery.model.Product
import kotlinx.android.synthetic.main.recycler_cart_product.view.*

class CartProductAdapter(private val context: Context) :
    RecyclerView.Adapter<CartProductAdapter.ProductsViewHolder>() {

    private var dataList = mutableListOf<Product>()

    fun setListData(data: MutableList<Product>) {
        dataList = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val productView =
            LayoutInflater.from(context).inflate(R.layout.recycler_cart_product, parent, false)
        return ProductsViewHolder(productView)
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        val product = dataList[position]
        holder.productBindView(product)

        holder.itemView.remove_product_button.setOnClickListener {
            dataList.remove(product)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        if (dataList.size > 0)
            return dataList.size

        return 0
    }

    inner class ProductsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun productBindView(product: Product) {
            Glide.with(context).load(product.image).into(itemView.imageProducto)
            itemView.product_name_txt.text = product.name
            itemView.product_price_txt.text = product.price.toString()
        }
    }
}