package com.example.primetimerealtorskt.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.primetimerealtorskt.R
import com.example.primetimerealtorskt.model.RecentData
import com.example.primetimerealtorskt.model.TopPlacesData


class ForsaleAdapter(var context: Context, recentDataList: List<TopPlacesData>) :
    RecyclerView.Adapter<ForsaleAdapter.TopPlacesViewHolder>() {
    var topPlacesDataList: List<TopPlacesData>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopPlacesViewHolder {
        val view: View =
            LayoutInflater.from(context).inflate(R.layout.top_places_data, parent, false)
        // here we create a recyclerview for items layout file
        return TopPlacesViewHolder(view)
    }

    override fun onBindViewHolder(holder: TopPlacesViewHolder, position: Int) {
        holder.countyName.setText(topPlacesDataList[position].countyName)
        holder.placeName.setText(topPlacesDataList[position].placeName)
        holder.price.setText(topPlacesDataList[position].price)
        holder.placeImage.setImageResource(topPlacesDataList[position].imageUrl)
    }

    override fun getItemCount(): Int {
        return topPlacesDataList.size
    }

    class TopPlacesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
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
        topPlacesDataList = recentDataList
    }
}
