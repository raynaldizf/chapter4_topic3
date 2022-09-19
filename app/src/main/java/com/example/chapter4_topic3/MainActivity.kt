package com.example.chapter4_topic3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chapter4_topic3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var vmProduct : ViewModelProduct
    lateinit var adapterProduct : ProductAdapter
    // Sebelum pake data binding
//    lateinit var rvProduct : RecyclerView
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Sebelum pake data binding
//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        // init viewmodel dan adapter
        vmProduct = ViewModelProvider(this).get(ViewModelProduct::class.java)
        adapterProduct = ProductAdapter(ArrayList())

        vmProduct.getProduct()
        vmProduct.productList.observe(this,Observer{
            adapterProduct.setDataProduct(it as ArrayList<ProductData>)
        })
        // Sebelum pake data binding
//        rvProduct = findViewById(R.id.rvProduct)
//        rvProduct.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
//        rvProduct.adapter = adapterProduct

        // Setelah pake data binding
        binding.rvProduct.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        binding.rvProduct.adapter = adapterProduct



    }
}