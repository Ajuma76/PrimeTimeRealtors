package com.example.primetimerealtorskt.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.primetimerealtorskt.R
import com.example.primetimerealtorskt.model.RecentData


class RecentAdapter(var context: Context, recentDataList: List<RecentData>) :
    RecyclerView.Adapter<RecentAdapter.RecentViewHolder>() {
    var recentDataList: List<RecentData>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecentViewHolder {
        val view: View =
            LayoutInflater.from(context).inflate(R.layout.recent_row_item, parent, false)
        // here we create a recyclerview for items layout file
        return RecentViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecentViewHolder, position: Int) {
        holder.countyName.setText(recentDataList[position].getCountyName())
        holder.placeName.setText(recentDataList[position].getPlaceName())
        holder.price.setText(recentDataList[position].getPrice())
        holder.placeImage.setImageResource(recentDataList[position].getImageUrl())

        //opening details activity
        holder.itemView.setOnClickListener {
            val i = Intent(context, DetailsActivity::class.java)
            context.startActivity(i)
        }
    }

    override fun getItemCount(): Int {
        return recentDataList.size
    }

    class RecentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var placeImage: ImageView
        var placeName: TextView
        var countyName: TextView
        var price: TextView

        init {
            placeImage = itemView.findViewById(R.id.placeImage)
            placeName = itemView.findViewById(R.id.placeName)
            countyName = itemView.findViewById(R.id.countyName)
            price = itemView.findViewById(R.id.price)
        }
    }

    init {
        this.recentDataList = recentDataList
    }
}
