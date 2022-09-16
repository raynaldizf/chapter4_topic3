package com.example.chapter4_topic3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(var listProduct : ArrayList<ProductData>) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var name = itemView.findViewById<TextView>(R.id.productName)
        var price = itemView.findViewById<TextView>(R.id.productPrice)
        var img = itemView.findViewById<ImageView>(R.id.imageProduct)
        var stock = itemView.findViewById<TextView>(R.id.productStock)
        var desc = itemView.findViewById<TextView>(R.id.productDescription)



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view =LayoutInflater.from(parent.context).inflate(R.layout.item_product,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var data = listProduct[position]
        holder.name.text = listProduct[position].nameProduct
        holder.price.text = data.hargaProduct.toString()
        holder.img.setImageResource(data.imgProduct)
        holder.stock.text = data.stockProduct.toString()
        holder.desc.text = data.descProduct

    }

    override fun getItemCount(): Int {
        return listProduct.size
    }
    fun setDataProduct(itemData : ArrayList<ProductData>){
        this.listProduct = itemData
    }
}