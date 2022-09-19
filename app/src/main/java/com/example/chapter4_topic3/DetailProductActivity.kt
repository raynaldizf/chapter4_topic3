package com.example.chapter4_topic3

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detil_product.*

class DetailProductActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detil_product)

        val getProduct = intent.getSerializableExtra("detailproduct") as ProductData
        imgDetailProduct.setImageResource(getProduct.imgProduct)
        productNameDetailProduct.text = getProduct.nameProduct
        productPriceDetailProduct.text = getProduct.hargaProduct.toString()
        productDescDetailProduct.text = getProduct.descProduct

        btnBuy.setOnClickListener {
            val phoneNumber = +6282223018700
            val pindah = Intent(Intent.ACTION_VIEW)
            pindah.data = Uri.parse(String.format("https://api.whatsapp.com/send?phone=$phoneNumber&text="+"Halo, Saya tertarik dengan produk ${getProduct.nameProduct} dengan harga Rp ${getProduct.hargaProduct.toString()}, Apakah masih tersedia?"))
            startActivity(pindah)
        }
    }
}