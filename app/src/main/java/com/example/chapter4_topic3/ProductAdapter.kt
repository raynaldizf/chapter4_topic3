package com.example.chapter4_topic3

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.chapter4_topic3.databinding.ActivityMainBinding
import com.example.chapter4_topic3.databinding.ItemProductBinding

class ProductAdapter(var listProduct : ArrayList<ProductData>) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    class ViewHolder(var binding: ItemProductBinding): RecyclerView.ViewHolder(binding.root){
//    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        // kerna make binding gak perlu findview
//        var name = itemView.findViewById<TextView>(R.id.productName)
//        var price = itemView.findViewById<TextView>(R.id.productPrice)
//        var img = itemView.findViewById<ImageView>(R.id.imageProduct)
//        var stock = itemView.findViewById<TextView>(R.id.productStock)
//        var desc = itemView.findViewById<TextView>(R.id.productDescription)

        // Data binding
        fun bindProduct(itemProduct : ProductData){
            binding.product = itemProduct
            binding.card.setOnClickListener(object : View.OnClickListener{
                override fun onClick(view: View?) {
                    var bun = Bundle()
                    bun.putSerializable("detailproduct", itemProduct)
                    val inten = Intent(view!!.context, DetailProductActivity::class.java)
                    inten.putExtras(bun)
                    view.context.startActivity(inten)
                }
            })
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Sebelum pake data binding
//        var view =LayoutInflater.from(parent.context).inflate(R.layout.item_product,parent,false)
//        return ViewHolder(view)

        // Setelah pakai data binding
        var view = ItemProductBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Sebelum pake data binding
//        var data = listProduct[position]
//        holder.name.text = listProduct[position].nameProduct
//        holder.price.text = data.hargaProduct.toString()
//        holder.img.setImageResource(data.imgProduct)
//        holder.stock.text = data.stockProduct.toString()
//        holder.desc.text = data.descProduct
        holder.bindProduct(listProduct[position])

    }

    override fun getItemCount(): Int {
        return listProduct.size
    }
    fun setDataProduct(itemData : ArrayList<ProductData>){
        this.listProduct = itemData
    }
}