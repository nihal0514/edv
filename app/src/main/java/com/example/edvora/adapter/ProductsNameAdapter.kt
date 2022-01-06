package com.example.edvora.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.edvora.R
import com.example.edvora.model.ProdName
import com.example.edvora.model.ProductsName

class ProductsNameAdapter(val context: Context,var prodlist:ArrayList<ProdName>):
    RecyclerView.Adapter<ProductsNameAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.prod_name_item,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.prodnametv.text = prodlist.get(position).brand_name

        val linearLayoutManager: LinearLayoutManager= LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        holder.subprodrecyv.layoutManager= linearLayoutManager
        val subProductsAdapter = SubProductsAdapter(context,prodlist.get(position).array)
        holder.subprodrecyv.adapter= subProductsAdapter
    }


    override fun getItemCount(): Int {
        return  prodlist.size
    }
    class MyViewHolder(itemView: View?): RecyclerView.ViewHolder(itemView!!)  {
        val prodnametv: TextView = itemView!!.findViewById(R.id.product_name_tv)
        val subprodrecyv : RecyclerView = itemView!!.findViewById(R.id.sub_prod_recyv)

    }
}
