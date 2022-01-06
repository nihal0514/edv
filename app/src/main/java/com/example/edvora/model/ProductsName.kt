package com.example.edvora.model

data class ProductsName (
    val product_name: String,
    val brand_name: String,
    val price: Int,
    val discription: String,
    val date: String,
    val time: String,
    val image: String,

    val address: ProdAddress
)