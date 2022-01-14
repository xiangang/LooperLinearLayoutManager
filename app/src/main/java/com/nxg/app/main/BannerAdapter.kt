package com.nxg.app.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.nxg.app.widget.R

class BannerAdapter(private val context: Context, private val dataList: List<BannerBean>) :
    RecyclerView.Adapter<BannerAdapter.NumberViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberViewHolder {
        return NumberViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_banner, parent, false)
        )
    }

    override fun onBindViewHolder(holder: NumberViewHolder, position: Int) {
        holder.title.text = dataList[position].title
        holder.desc.text = dataList[position].desc
        holder.index.text = (position + 1).toString()
        holder.image.load(dataList[position].image)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    class NumberViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.banner_img)
        val title: TextView = itemView.findViewById(R.id.banner_title)
        val desc: TextView = itemView.findViewById(R.id.banner_desc)
        val index: TextView = itemView.findViewById(R.id.banner_index)
    }
}