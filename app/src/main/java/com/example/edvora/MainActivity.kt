package com.example.edvora

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.edvora.adapter.ProductsNameAdapter
import com.example.edvora.api.ProductsNameApi
import com.example.edvora.model.ProdName
import com.example.edvora.model.ProductsName
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var recyclerAdapter: ProductsNameAdapter
    private var hmap: HashMap<String,ArrayList<ProductsName>> = HashMap<String,ArrayList<ProductsName>>()
    private var prodlist: ArrayList<ProdName> = ArrayList()

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.product_name_recyv)
        recyclerAdapter = ProductsNameAdapter(this,prodlist)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = recyclerAdapter

        val productsnameapi= ProductsNameApi.create().getProducts()

        productsnameapi.enqueue(object:Callback<List<ProductsName>>{
            override fun onResponse(call: Call<List<ProductsName>>, response: Response<List<ProductsName>>?) {
                hmap.clear()
                prodlist.clear()
                if(response?.body()!=null){
                    for (alist in response.body()!!){
                        if(hmap.containsKey(alist.brand_name)){
                            hmap.get(alist.brand_name)?.add(alist)
                        }else{
                            var temp: ArrayList<ProductsName> = ArrayList()
                            temp.add(alist)
                            hmap.put(alist.brand_name,temp)
                        }

                    }
                    for((key, value) in hmap){
                        prodlist.add(ProdName(key,value))
                    }
                    recyclerAdapter.notifyDataSetChanged()

                }
            }

            override fun onFailure(call: Call<List<ProductsName>>, t: Throwable) {
                Toast.makeText(applicationContext,t.message,Toast.LENGTH_LONG).show()
                Log.d("mm",t.message.toString())
            }
        })

    }
}