package com.example.primetimerealtorskt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.primetimerealtorskt.adapter.RecentAdapter
import com.example.primetimerealtorskt.adapter.TopPlacesAdapter
import com.example.primetimerealtorskt.model.RecentData
import com.example.primetimerealtorskt.model.TopPlacesData
import java.util.ArrayList


class MainActivity : AppCompatActivity() {
    var recentRecycler: RecyclerView? = null
    var topPlacesRecycler: RecyclerView? = null
    var recentAdapter: RecentAdapter? = null
    var topPlacesAdapter: TopPlacesAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //add description to our home
        val recentDataList: MutableList<RecentData> = ArrayList<RecentData>()
        recentDataList.add(RecentData("Runda Estate", "Nairobi", "Ksh. 22M", R.drawable.karen2))
        recentDataList.add(RecentData("Elementaita", "Nakuru", "Ksh. 13.6M", R.drawable.karen3))
        recentDataList.add(RecentData("Runda Estate", "Nairobi", "Ksh. 22M", R.drawable.karen2))
        recentDataList.add(RecentData("Elementaita", "Nakuru", "Ksh. 13.6M", R.drawable.karen3))
        recentDataList.add(RecentData("Runda Estate", "Nairobi", "Ksh. 22M", R.drawable.karen2))
        recentDataList.add(RecentData("Elementaita", "Nakuru", "Ksh. 13.6M", R.drawable.karen3))
        setRecentRecycler(recentDataList)
        val topPlacesDataList: MutableList<TopPlacesData> = ArrayList<TopPlacesData>()
        topPlacesDataList.add(
            TopPlacesData(
                "Kileleshwa",
                "Nairobi",
                "Ksh. 19M",
                R.drawable.karen22
            )
        )
        topPlacesDataList.add(
            TopPlacesData(
                "Kitusuru",
                "Nairobi",
                "Ksh. 30M",
                R.drawable.kileleshwa
            )
        )
        topPlacesDataList.add(
            TopPlacesData(
                "Kileleshwa",
                "Nairobi",
                "Ksh. 19M",
                R.drawable.karen22
            )
        )
        topPlacesDataList.add(
            TopPlacesData(
                "Kileleshwa",
                "Nairobi",
                "Ksh. 19M",
                R.drawable.karen22
            )
        )
        topPlacesDataList.add(
            TopPlacesData(
                "Kileleshwa",
                "Nairobi",
                "Ksh. 19M",
                R.drawable.karen22
            )
        )
        setTopPlacesRecycler(topPlacesDataList)
    }

    private fun setRecentRecycler(recentDataList: List<RecentData>) {
        recentRecycler = findViewById(R.id.recentRecycle)
        val layoutManager: RecyclerView.LayoutManager =
            LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        recentRecycler.setLayoutManager(layoutManager)
        recentAdapter = RecentAdapter(this, recentDataList)
        recentRecycler.setAdapter(recentAdapter)
    }

    private fun setTopPlacesRecycler(topPlacesDataList: List<TopPlacesData>) {
        topPlacesRecycler = findViewById(R.id.top_places_recycler)
        val layoutManager: RecyclerView.LayoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        topPlacesRecycler.setLayoutManager(layoutManager)
        topPlacesAdapter = TopPlacesAdapter(this, topPlacesDataList)
        topPlacesRecycler.setAdapter(topPlacesAdapter)
    }
}