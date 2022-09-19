package com.example.chapter4_topic3

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelProduct : ViewModel() {
    val listProduct = arrayListOf(
        ProductData("Cocacola",R.drawable.cocacola,6000,20,"Minuman Bersoda Mantap"),
        ProductData("Sprite",R.drawable.sprite,6500,25,"Minuman Bersoda Mantap"),
        ProductData("Kopi Kapal Api",R.drawable.kapalapi,3000,16,"Kopi Mantap Gak Bikin Ngantuk"),
    )
    val productList: MutableLiveData<List<ProductData>> = MutableLiveData()

    // set data ke livedata
    fun getProduct(){
        var product = listProduct
        productList.value =product
    }
}