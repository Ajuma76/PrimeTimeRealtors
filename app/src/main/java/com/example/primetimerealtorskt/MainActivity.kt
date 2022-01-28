package com.example.primetimerealtorskt

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
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

    var imageIconHome:ImageView?=null
    var imageIconCategory:ImageView?=null
    var imageIconProfile:ImageView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageIconHome = findViewById(R.id.mImgHomeIcon)
        imageIconCategory = findViewById(R.id.mImgCategoryIcon)
        imageIconProfile = findViewById(R.id.mImgProfileIcon)

        //add description to our home
        val recentDataList: MutableList<RecentData> = ArrayList<RecentData>()
        recentDataList.add(RecentData("Lavington Estate", "Nairobi", "Ksh. 422M", R.drawable.ridgeways))
        recentDataList.add(RecentData("Lanet Estate", "Nakuru", "Ksh. 613.6M", R.drawable.lanet))
        recentDataList.add(RecentData("Kilimani Estate", "Nairobi", "Ksh. 522M", R.drawable.kilimani))
        recentDataList.add(RecentData("Hurlinghum Estate", "Nairobi", "Ksh. 13.6M", R.drawable.hurlinghum))
        recentDataList.add(RecentData("Rosslyn Estate", "Nairobi", "Ksh. 22M", R.drawable.karen2))
        setRecentRecycler(recentDataList)
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
                R.drawable.nyari
            )
        )

        setTopPlacesRecycler(topPlacesDataList)

        imageIconHome!!.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }

        imageIconCategory!!.setOnClickListener {
            startActivity(Intent(this,CategoriesActivity2::class.java))
        }

        imageIconProfile!!.setOnClickListener {
            startActivity(Intent(this,ProfileActivity::class.java))
        }
    }

    private fun setRecentRecycler(recentDataList: List<RecentData>) {
        recentRecycler = findViewById(R.id.recentRecycle)
        val layoutManager: RecyclerView.LayoutManager =
            LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        recentRecycler!!.setLayoutManager(layoutManager)
        recentAdapter = RecentAdapter(this, recentDataList)
        recentRecycler!!.setAdapter(recentAdapter)
    }

    private fun setTopPlacesRecycler(topPlacesDataList: List<TopPlacesData>) {
        topPlacesRecycler = findViewById(R.id.top_places_recycler)
        val layoutManager: RecyclerView.LayoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        topPlacesRecycler!!.setLayoutManager(layoutManager)
        topPlacesAdapter = TopPlacesAdapter(this, topPlacesDataList)
        topPlacesRecycler!!.setAdapter(topPlacesAdapter)
    }


}