package com.example.chapter4_topic3

import java.io.Serializable

data class ProductData(
    var nameProduct : String,
    var imgProduct : Int,
    var hargaProduct : Int,
    var stockProduct : Int,
    var descProduct : String
) : Serializable
