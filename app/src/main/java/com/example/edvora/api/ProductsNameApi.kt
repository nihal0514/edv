package com.example.edvora.api

import com.example.edvora.model.ProductsName
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ProductsNameApi {
    @GET(".")
    fun getProducts(): Call<List<ProductsName>>

    companion object {
        fun create() : ProductsNameApi {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://assessment-edvora.herokuapp.com")
                .build()
            return retrofit.create(ProductsNameApi::class.java)

        }
    }
}