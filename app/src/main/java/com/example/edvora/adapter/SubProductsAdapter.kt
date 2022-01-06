package com.example.edvora.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.edvora.R
import com.example.edvora.model.ProdName
import com.example.edvora.model.ProductsName

class SubProductsAdapter(val context: Context, var prodlist:ArrayList<ProductsName>):
    RecyclerView.Adapter<SubProductsAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.prod_details_item,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.prodnametv.text = prodlist.get(position).product_name
        holder.pricetv.text = prodlist.get(position).price.toString()
        holder.brandname.text = prodlist.get(position).brand_name
        holder.location.text = prodlist.get(position).address.city
        holder.date.text = prodlist.get(position).date.subSequence(0,10)
        holder.descp.text = prodlist.get(position).discription
        Glide.with(context).load(prodlist.get(position).image)
            .apply(RequestOptions().centerCrop())
            .into(holder.imageview)

    }

    override fun getItemCount(): Int {
        return  prodlist.size
    }
    class MyViewHolder(itemView: View?): RecyclerView.ViewHolder(itemView!!)  {
        val prodnametv: TextView = itemView!!.findViewById(R.id.product_name)
        val pricetv: TextView = itemView!!.findViewById(R.id.price)
        val imageview: ImageView = itemView!!.findViewById(R.id.image_view)
        val brandname: TextView = itemView!!.findViewById(R.id.brand_name)
        val location: TextView = itemView!!.findViewById(R.id.location_tv)
        val date: TextView = itemView!!.findViewById(R.id.date_tv)
        val descp: TextView = itemView!!.findViewById(R.id.description_tv)

    }
}
