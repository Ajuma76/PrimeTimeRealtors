package com.example.primetimerealtorskt

import com.example.primetimerealtorskt.model.TopPlacesData


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomAdapter(var context: Context, var data:ArrayList<TopPlacesData>):BaseAdapter() {
    private class ViewHolder(row:View?){
        var placeName:TextView
        var countyName:TextView
        var price:TextView
        var imageUrl:ImageView
        init {
            this.placeName = row?.findViewById(R.id.placeName) as TextView
            this.countyName = row?.findViewById(R.id.countyName) as TextView
            this.price = row?.findViewById(R.id.price) as TextView
            this.imageUrl = row?.findViewById(R.id.placeImage) as ImageView
        }
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view:View?
        var viewHolder:ViewHolder
        if (convertView == null){
            var layout = LayoutInflater.from(context)
            view = layout.inflate(R.layout.top_places_data,parent,false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        }else{
            view = convertView
            viewHolder = view.tag as ViewHolder
        }
        var item:TopPlacesData = getItem(position) as TopPlacesData
        viewHolder.placeName.text = item.placeName
        viewHolder.countyName.text = item.countyName
        viewHolder.price.text = item.price
        viewHolder.imageUrl.setImageResource(item.imageUrl)
        return view as View
    }

    override fun getItem(position: Int): Any {
        return  data.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return data.count()
    }
}