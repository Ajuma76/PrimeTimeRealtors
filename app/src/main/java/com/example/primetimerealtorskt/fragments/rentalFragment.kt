package com.example.primetimerealtorskt.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import com.example.primetimerealtorskt.*
import com.example.primetimerealtorskt.model.TopPlacesData
import java.util.ArrayList


class rentalFragment : Fragment() {


    var mListListPlaces: ListView? = null
    var adapter: CustomAdapter? = null
    var topPlacesDataList: ArrayList<TopPlacesData>? = null



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var root =  inflater.inflate(R.layout.fragment_rental, container, false)
        mListListPlaces = root.findViewById(R.id.mListListPlaces)

        topPlacesDataList = ArrayList()
        adapter = context?.let { CustomAdapter(it,topPlacesDataList!!) }
        topPlacesDataList!!.add(
            TopPlacesData(
                "Lower Kabete Estate",
                "Nairobi",
                "Ksh. 350,000/Month (3Bedrooms)",
                R.drawable.lowerkabet1e
            )
        )
        topPlacesDataList!!.add(
            TopPlacesData(
                "Ngong Estate",
                "Nairobi",
                "Ksh. 150,000/Month (3Bedrooms)",
                R.drawable.kitisuru
            )
        )
        topPlacesDataList!!.add(
            TopPlacesData(
                "Spring Valley Estate",
                "Nairobi",
                "Ksh. 250,000/Month (2Bedrooms)",
                R.drawable.karen
            )
        )
        topPlacesDataList!!.add(
            TopPlacesData(
                "Westlands",
                "Nairobi",
                "Ksh. 180,000/Month (3Bedrooms)",
                R.drawable.karen22
            )
        )
        topPlacesDataList!!.add(
            TopPlacesData(
                "Red Hill",
                "Nairobi",
                "Ksh. 540,000/Month (4Bedrooms)",
                R.drawable.karen22
            )
        )
        mListListPlaces!!.adapter = adapter
        mListListPlaces!!.setOnItemClickListener(AdapterView.OnItemClickListener { adapterView, view, i, l ->
            var placeName = topPlacesDataList!!.get(i).placeName
            var countyName = topPlacesDataList!!.get(i).countyName
            var price = topPlacesDataList!!.get(i).price
            var image = topPlacesDataList!!.get(i).imageUrl
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra("placeImage", image)
            intent.putExtra("placeName", placeName)
            intent.putExtra("countyName", countyName)
            intent.putExtra("price", price)
            startActivity(intent)

        })

        return root;
    }




}