package com.example.primetimerealtorskt.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.primetimerealtorskt.R
import com.example.primetimerealtorskt.adapter.RecentAdapter
import com.example.primetimerealtorskt.adapter.TopPlacesAdapter
import com.example.primetimerealtorskt.model.TopPlacesData
import java.util.ArrayList


class ForsaleFragment : Fragment() {
    var topPlacesRecycler: RecyclerView? = null
    var recentAdapter: RecentAdapter? = null
    var topPlacesAdapter: TopPlacesAdapter? = null




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var root =  inflater.inflate(R.layout.fragment_forsale, container, false)
        topPlacesRecycler = root.findViewById(R.id.top_places_recycler)
        val topPlacesDataList: MutableList<TopPlacesData> = ArrayList<TopPlacesData>()
        topPlacesDataList.add(
            TopPlacesData(
                "Kileleshwa Estate",
                "Nairobi",
                "Ksh. 19M",
                R.drawable.kileleshwa
            )
        )
        topPlacesDataList.add(
            TopPlacesData(
                "Kitusuru Estate",
                "Nairobi",
                "Ksh. 30M",
                R.drawable.kitisuru
            )
        )
        topPlacesDataList.add(
            TopPlacesData(
                "Karen Estate",
                "Nairobi",
                "Ksh. 19M",
                R.drawable.karen
            )
        )
        topPlacesDataList.add(
            TopPlacesData(
                "Nyari Estate",
                "Nairobi",
                "Ksh. 19M",
                R.drawable.karen22
            )
        )
        setTopPlacesRecycler(topPlacesDataList)


        return  root
    }

    private fun setTopPlacesRecycler(topPlacesDataList: List<TopPlacesData>) {

        val layoutManager: RecyclerView.LayoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        topPlacesRecycler!!.setLayoutManager(layoutManager)
        topPlacesAdapter = context?.let { TopPlacesAdapter(it, topPlacesDataList) }
        topPlacesRecycler!!.setAdapter(topPlacesAdapter)
    }


}