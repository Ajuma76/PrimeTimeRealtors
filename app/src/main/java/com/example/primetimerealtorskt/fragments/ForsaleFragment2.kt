package com.example.primetimerealtorskt.fragments

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.primetimerealtorskt.CustomAdapter
import com.example.primetimerealtorskt.DetailsActivity
import com.example.primetimerealtorskt.R
import com.example.primetimerealtorskt.adapter.RecentAdapter
import com.example.primetimerealtorskt.adapter.TopPlacesAdapter
import com.example.primetimerealtorskt.model.TopPlacesData
import java.util.ArrayList

class ForsaleFragment2 : Fragment() {

    var mListListPlaces: ListView? = null
    var adapter:CustomAdapter? = null
    var topPlacesDataList:ArrayList<TopPlacesData>? = null



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var root =  inflater.inflate(R.layout.forsale_fragment2_fragment, container, false)
        mListListPlaces = root.findViewById(R.id.mListListPlaces)

        topPlacesDataList = ArrayList()
        adapter = context?.let { CustomAdapter(it,topPlacesDataList!!) }
        topPlacesDataList!!.add(
            TopPlacesData(
                "Kileleshwa Estate",
                "Nairobi",
                "Ksh. 560M",
                R.drawable.kileleshwa
            )
        )
        topPlacesDataList!!.add(
            TopPlacesData(
                "Kitusuru Estate",
                "Nairobi",
                "Ksh. 430M",
                R.drawable.kitisuru
            )
        )
        topPlacesDataList!!.add(
            TopPlacesData(
                "Karen Estate",
                "Nairobi",
                "Ksh. 606M",
                R.drawable.karen
            )
        )
        topPlacesDataList!!.add(
            TopPlacesData(
                "Nyari Estate",
                "Nairobi",
                "Ksh. 619M",
                R.drawable.karen22
            )
        )
        topPlacesDataList!!.add(
            TopPlacesData(
                "Gigiri Estate",
                "Nairobi",
                "Ksh. 311M",
                R.drawable.gigiri
            )
        )
        topPlacesDataList!!.add(
            TopPlacesData(
                "Hurlinghum",
                "Nairobi",
                "Ksh. 411M",
                R.drawable.hurlinghum
            )
        )
        topPlacesDataList!!.add(
            TopPlacesData(
                "Kilimani",
                "Nairobi",
                "Ksh. 410M",
                R.drawable.kilimani
            )
        )
        topPlacesDataList!!.add(
            TopPlacesData(
                "Lanet Estate",
                "Nakuru",
                "Ksh. 870M",
                R.drawable.lanet
            )
        )
        topPlacesDataList!!.add(
            TopPlacesData(
                "Kiamunyi Estate",
                "Nakuru",
                "Ksh. 319.4M",
                R.drawable.riverside
            )
        )
        topPlacesDataList!!.add(
            TopPlacesData(
                "Mtwapa Creek",
                "Kilifi",
                "Ksh. 619M",
                R.drawable.gigiri
            )
        )
        topPlacesDataList!!.add(
            TopPlacesData(
                "Riversise Estate",
                "Nairobi",
                "Ksh. 319.8M",
                R.drawable.riverside
            )
        )
        topPlacesDataList!!.add(
            TopPlacesData(
                "Muthaiga Estate",
                "Nairobi",
                "Ksh. 419M",
                R.drawable.muthaiga
            )
        )
        topPlacesDataList!!.add(
            TopPlacesData(
                "Nyari Estate",
                "Nairobi",
                "Ksh. 700M",
                R.drawable.karen22
            )
        )
        topPlacesDataList!!.add(
            TopPlacesData(
                "Kerio Valley Ranch",
                "Nairobi",
                "Ksh. 819M",
                R.drawable.keriovalley
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