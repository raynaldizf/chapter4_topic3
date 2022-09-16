package com.example.chapter4_topic3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var vmProduct : ViewModelProduct
    lateinit var adapterProduct : ProductAdapter
    lateinit var rvProduct : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // init viewmodel dan adapter
        vmProduct = ViewModelProvider(this).get(ViewModelProduct::class.java)
        adapterProduct = ProductAdapter(ArrayList())

        vmProduct.getProduct()
        vmProduct.productList.observe(this,Observer{
            adapterProduct.setDataProduct(it as ArrayList<ProductData>)
        })

        rvProduct = findViewById(R.id.rvProduct)
        rvProduct.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        rvProduct.adapter = adapterProduct



    }
}